
package org.crosswire.jsword.book.remote;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.crosswire.jsword.book.BibleMetaData;
import org.crosswire.jsword.book.basic.AbstractBibleDriver;
import org.jdom.Document;

/**
 * This represents all of the SerBibles.
 *
 * <table border='1' cellPadding='3' cellSpacing='0' width="100%">
 * <tr><td bgColor='white'class='TableRowColor'><font size='-7'>
 * Distribution Licence:<br />
 * Project B is free software; you can redistribute it
 * and/or modify it under the terms of the GNU General Public License,
 * version 2 as published by the Free Software Foundation.<br />
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br />
 * The License is available on the internet
 * <a href='http://www.gnu.org/copyleft/gpl.html'>here</a>, by writing to
 * <i>Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston,
 * MA 02111-1307, USA</i>, Or locally at the Licence link below.<br />
 * The copyright to this program is held by it's authors.
 * </font></td></tr></table>
 * @see <a href='http://www.eireneh.com/servlets/Web'>Project B Home</a>
 * @see <{docs.Licence}>
 * @author Joe Walker
 * @version $Id$
 */
public abstract class RemoteBibleDriver extends AbstractBibleDriver
{
    /**
     * Accessor for the current remoter.
     * @see org.crosswire.jsword.book.remote.RemoteBibleDriver#getXML(java.lang.String)
     * @return The remoter or null if none is available.
     */
    protected abstract Remoter getRemoter();

    /**
     * Get a list of the Books available from the name.
     * We cache the reply, for speed but we probably ought to have some way to
     * flush the cache because the list of Bibles on the server could change.
     * @return an array of book names
     */
    public BibleMetaData[] getBibles()
    {
        synchronized (this)
        {
            if (rbmd == null)
            {
                try
                {
                    Remoter remoter = getRemoter();
                    if (remoter == null)
                    {
                        rbmd = new RemoteBibleMetaData[0];
                    }

                    RemoteMethod method = new RemoteMethod(RemoteConstants.METHOD_GETBIBLES);
                    Document doc = remoter.execute(method);

                    rbmd = Converter.convertDocumentToBibleMetaDatas(doc, getRemoter());

                    for (int i=0; i<rbmd.length; i++)
                    {
                        ids.put(rbmd[i].getID(), rbmd[i]);
                    }
                }
                catch (Exception ex)
                {
                    log.warn("failed to remote getBibleNames", ex);
                    rbmd = new RemoteBibleMetaData[0];
                }
            }
        }

        return rbmd;
    }

    /**
     * The log stream
     */
    protected static Logger log = Logger.getLogger(RemoteBibleDriver.class);

    /**
     * The cache of Bible names.
     * At some stage it would be good to work out a way to clear the cache.
     */
    private RemoteBibleMetaData[] rbmd;

    /**
     * The id to metadata map
     */
    private Map ids = new HashMap();
}

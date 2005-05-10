/**
 * Distribution License:
 * JSword is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License, version 2 as published by
 * the Free Software Foundation. This program is distributed in the hope
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * The License is available on the internet at:
 *       http://www.gnu.org/copyleft/gpl.html
 * or by writing to:
 *      Free Software Foundation, Inc.
 *      59 Temple Place - Suite 330
 *      Boston, MA 02111-1307, USA
 *
 * Copyright: 2005
 *     The copyright to this program is held by it's authors.
 *
 * ID: $Id$
 */
package org.crosswire.jsword.book.basic;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.BookDriver;
import org.crosswire.jsword.book.BookException;

/**
 * The AbstractBookDriver class implements some BibleDriver methods, making a
 * simple read-only BibleDriver.
 * 
 * @see gnu.gpl.Licence for license details.
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public abstract class AbstractBookDriver implements BookDriver
{
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.BookDriver#isWritable()
     */
    public boolean isWritable()
    {
        return false;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.BookDriver#create(org.crosswire.jsword.book.Book, org.crosswire.jsword.book.events.WorkListener)
     */
    public Book create(Book source) throws BookException
    {
        throw new BookException(Msg.DRIVER_READONLY);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.BookDriver#isDeletable(org.crosswire.jsword.book.Book)
     */
    public boolean isDeletable(Book dead)
    {
        return false;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.BookDriver#delete(org.crosswire.jsword.book.Book)
     */
    public void delete(Book dead) throws BookException
    {
        throw new BookException(Msg.DRIVER_READONLY);
    }
}

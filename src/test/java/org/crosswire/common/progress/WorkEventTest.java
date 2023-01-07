package org.crosswire.common.progress;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit Test.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class WorkEventTest {
    @Test
    public void testGetJob() {
        Progress job = JobManager.createJob("wibble");
        job.beginJob("wibble");
        WorkEvent ev = new WorkEvent(job);

        assertEquals(job, ev.getJob());
        assertEquals(job, ev.getSource());
    }
}

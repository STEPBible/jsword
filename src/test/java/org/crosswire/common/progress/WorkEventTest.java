package org.crosswire.common.progress;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit Test.
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

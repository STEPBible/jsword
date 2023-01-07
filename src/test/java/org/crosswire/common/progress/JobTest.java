package org.crosswire.common.progress;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.UUID;

import org.junit.Test;

/**
 * JUnit Test.
 */
public class JobTest {

    private static final String WIBBLE = "wibble";

    @Test
    public void testJob() throws IOException {
        Progress job;
        File tempfile = File.createTempFile("jobtest", "tmp");
        URI uri = tempfile.toURI();

        job = JobManager.createJob(WIBBLE);
        job.beginJob(WIBBLE);

        assertEquals(WIBBLE, job.getJobName());
        assertFalse(job.isFinished());
        assertFalse(job.isCancelable());
        assertEquals(WIBBLE, job.getSectionName());
        assertEquals(0, job.getWork());
        job.done();
        assertTrue(job.isFinished());
        assertEquals(100, job.getWork());
        assertFalse(job.isCancelable());

        job = JobManager.createJob(UUID.randomUUID().toString(), WIBBLE, Thread.currentThread());
        job.beginJob(WIBBLE);
        assertEquals(WIBBLE, job.getJobName());
        assertFalse(job.isFinished());
        assertTrue(job.isCancelable());
        assertEquals(WIBBLE, job.getSectionName());
        assertEquals(0, job.getWork());
        job.done();
        assertTrue(job.isFinished());
        assertEquals(100, job.getWork());
        // assertEquals(job.isCancelable(), false);

        job = JobManager.createJob(WIBBLE);
        job.beginJob(WIBBLE, uri);
        job.setTotalWork(100);
        assertEquals(WIBBLE, job.getJobName());
        assertFalse(job.isFinished());
        assertFalse(job.isCancelable());
        assertEquals(WIBBLE, job.getSectionName());
        job.cancel();
        job.done();
        assertTrue(job.isFinished());
        assertEquals(100, job.getWork());
        // assertFalse(job.isCancelable());

        job = JobManager.createJob(UUID.randomUUID().toString(), WIBBLE, Thread.currentThread());
        job.beginJob(WIBBLE, uri);
        assertEquals(WIBBLE, job.getJobName());
        assertFalse(job.isFinished());
        assertTrue(job.isCancelable());
        assertEquals(WIBBLE, job.getSectionName());
        job.done();
        assertTrue(job.isFinished());
        assertEquals(100, job.getWork());
        // assertFalse(job.isCancelable());
    }
}

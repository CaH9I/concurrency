package com.expertsoft.ex1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnsafeSequenceTest {

    private static final int TIMES = 1_000_000;

    private UnsafeSequence sequence;

    @Before
    public void init() {
        sequence = new UnsafeSequence();
    }

    /**
     * Probably you might need execute this test several times in order to fail.
     */
    @Test
    public void unsafeSequence() throws InterruptedException {
        Thread t1 = new Thread(this::sequenceLoop);
        Thread t2 = new Thread(this::sequenceLoop);

        t1.start();
        t2.start();

        //wait until all the threads complete execution
        t1.join();
        t2.join();

        Assert.assertEquals(TIMES * 2, sequence.current());
    }

    private void sequenceLoop() {
        for (int i = 0; i < TIMES; i++) {
            sequence.next();
        }
    }
}

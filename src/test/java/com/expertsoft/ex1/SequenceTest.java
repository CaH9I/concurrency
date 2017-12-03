package com.expertsoft.ex1;

import org.junit.Assert;
import org.junit.Test;

public abstract class SequenceTest {

    private static final int TIMES = 1_000_000;

    protected Sequence sequence;

    /**
     * {@code sequence} must be initialized here.
     */
    public abstract void init();

    @Test
    public void sequenceTest() throws InterruptedException {
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

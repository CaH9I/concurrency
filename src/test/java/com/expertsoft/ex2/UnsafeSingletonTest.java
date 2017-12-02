package com.expertsoft.ex2;

import org.junit.Assert;
import org.junit.Test;

public class UnsafeSingletonTest {

    /**
     * This test fails with a high probability.
     */
    @Test
    public void twoSingletonInstances() throws InterruptedException {
        final UnsafeSingleton[] result = new UnsafeSingleton[2];
        Thread t1 = new Thread(() -> result[0] = UnsafeSingleton.getInstance());
        Thread t2 = new Thread(() -> result[1] = UnsafeSingleton.getInstance());

        t1.start();
        t2.start();

        //wait until all the threads complete execution
        t1.join();
        t2.join();

        Assert.assertEquals(result[0], result[1]);
    }
}

package com.expertsoft.ex5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThreadLocalTest {

    private ThreadLocal<String> threadLocal;

    private String[] result;

    @Before
    public void init() {
        threadLocal = new ThreadLocal<>();
        result = new String[2];
    }

    @Test
    public void hasOwnValue() throws InterruptedException {
        Thread t1 = new Thread(() -> run(0));
        Thread t2 = new Thread(() -> run(1));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Assert.assertNotEquals(result[0], result[1]);
    }

    private void run(int resultIndex) {
        // all the threads use the same object
        threadLocal.set(Thread.currentThread().getName());
        try {
            // give other thread a time to write to threadLocal
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result[resultIndex] = threadLocal.get();
    }
}

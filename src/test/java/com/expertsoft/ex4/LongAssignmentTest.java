package com.expertsoft.ex4;

import org.junit.Assert;
import org.junit.Test;

public class LongAssignmentTest {

    private long sharedValue = Long.MIN_VALUE;
    private boolean isSharedValueValidAlwaysTrue = true;

    private class LongAssigner extends Thread {

        private long value;

        public LongAssigner(long value) {
            this.value = value;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                // long assignment is not atomic
                sharedValue = value;
                if (!isSharedValueValid()) {
                    isSharedValueValidAlwaysTrue = false;
                    break;
                }
            }
        }
    }

    /**
     * You might need execute this test several times in order to fail.
     */
    @Test
    public void longAssignmentAtomicityTest() throws InterruptedException {
        LongAssigner t1 = new LongAssigner(Long.MAX_VALUE);
        LongAssigner t2 = new LongAssigner(Long.MIN_VALUE);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Assert.assertTrue(isSharedValueValidAlwaysTrue);
    }

    private boolean isSharedValueValid() {
        return (sharedValue == Long.MAX_VALUE)
            || (sharedValue == Long.MIN_VALUE);
    }
}

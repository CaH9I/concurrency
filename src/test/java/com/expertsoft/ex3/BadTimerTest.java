package com.expertsoft.ex3;

import org.junit.Before;
import org.junit.Test;

public class BadTimerTest {

    private BadTimer timer;

    @Before
    public void init() {
        timer = new BadTimer();
    }

    /**
     * It might take much time (up to forever) in order the timer to stop
     */
    @Test(timeout = 1_000L)
    public void timerTest() throws InterruptedException {
        //run the timer
        timer.startTimer();

        //timer is running
        Thread.sleep(100L);

        //request the timer to stop
        timer.stopTimer();

        //wait until the timer is stopped
        timer.join();
    }
}

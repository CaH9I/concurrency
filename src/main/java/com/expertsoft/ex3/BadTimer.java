package com.expertsoft.ex3;

public class BadTimer extends Thread {

    // each thread has its local copy of the flag
    private boolean stop;

    @Override
    public void run() {
        while (!stop);
    }

    public void startTimer() {
        start();
    }

    public void stopTimer() {
        stop = true;
    }
}

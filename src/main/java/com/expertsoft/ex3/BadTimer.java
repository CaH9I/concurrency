package com.expertsoft.ex3;

public class BadTimer extends Thread {

    // since the variable is not volatile, flag may not be up to date
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

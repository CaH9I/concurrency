package com.expertsoft.ex2;

import com.expertsoft.NotThreadSafe;

@NotThreadSafe
public class UnsafeSingleton {

    private static UnsafeSingleton expensiveObject;

    private UnsafeSingleton() {
        try {
            // It takes a time to initialize the state ...
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException("Unable to create", e);
        }
    }

    public static UnsafeSingleton getInstance() {
        if (expensiveObject == null) {
            expensiveObject = new UnsafeSingleton();
        }
        return expensiveObject;
    }
}

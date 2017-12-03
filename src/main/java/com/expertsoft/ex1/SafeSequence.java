package com.expertsoft.ex1;

import java.util.concurrent.atomic.AtomicInteger;

import com.expertsoft.ThreadSafe;

@ThreadSafe
public class SafeSequence implements Sequence {

    private AtomicInteger value = new AtomicInteger();

    @Override
    public int next() {
        return value.incrementAndGet();
    }

    @Override
    public int current() {
        return value.get();
    }
}

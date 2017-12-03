package com.expertsoft.ex1;

import com.expertsoft.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence implements Sequence {

    private int value;

    @Override
    public int next() {
        return ++value;
    }

    @Override
    public int current() {
        return value;
    }
}

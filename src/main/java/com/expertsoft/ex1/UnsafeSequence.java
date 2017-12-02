package com.expertsoft.ex1;

import com.expertsoft.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {

    private int value;

    /**
     * @return current sequence value
     */
    public int next() {
        return ++value;
    }

    /**
     * @return current sequence value
     */
    public int current() {
        return value;
    }
}

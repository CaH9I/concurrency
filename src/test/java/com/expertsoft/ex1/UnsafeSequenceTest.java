package com.expertsoft.ex1;

import org.junit.Before;

/**
 * You might need execute this test class several times in order to fail.
 */
public class UnsafeSequenceTest extends SequenceTest {

    @Before
    @Override
    public void init() {
        sequence = new UnsafeSequence();
    }
}

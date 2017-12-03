package com.expertsoft.ex1;

import org.junit.Before;

public class SafeSequenceTest extends SequenceTest {

    @Before
    @Override
    public void init() {
        sequence = new SafeSequence();
    }
}

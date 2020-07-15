package com.nedap.healthcare.aqlparser;

import com.nedap.healthcare.aqlparser.model.Lookup;
import org.junit.Before;

public class BaseTest {

    protected Lookup lookup;

    @Before
    public void setup() {
        lookup = new Lookup();
    }
}

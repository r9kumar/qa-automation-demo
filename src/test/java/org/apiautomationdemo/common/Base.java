package org.apiautomationdemo.common;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public class Base {
    private String sessionId;

    @Rule
    public final TestName name = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };

    @Before
    public void setUp() throws Exception {
       
    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Override
    public String getSessionId() {
        return this.sessionId;
    }
}
package org.sc.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DemoTest {

    @Test
    void testSpyWithVerify() {
        ABC abc = Mockito.spy();

        abc.method();
        verify(abc, times(1)).method();
    }

    public static class ABC{
        void method(){

        }
    }
}

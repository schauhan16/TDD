package org.sc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestExample {

    @Autowired
    private A a;
    
    @Test
    void testAutowired(){
        Assertions.assertTrue(true);
    }
    
}

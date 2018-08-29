package com.pandaria.scheduler.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
public class SimpleExampleTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SimpleExample simpleExample;

    @Test
    public void testRun() {
        try {
            simpleExample.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

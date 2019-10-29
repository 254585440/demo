package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(locations = "classpath:/application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

}

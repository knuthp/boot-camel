package com.knuthp.boot.camel;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootCamelApplication.class)
@WebAppConfiguration
@Ignore
public class BootCamelApplicationTests {

	@Test
	public void contextLoads() {
	}

}

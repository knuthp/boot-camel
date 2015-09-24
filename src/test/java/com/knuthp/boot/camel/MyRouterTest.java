package com.knuthp.boot.camel;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.knuthp.boot.camel.jpa.TimerBody;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@SpringApplicationConfiguration(classes = { MyRouterTest.class,
		TimerBody.class, MyRouter.class })
@IntegrationTest
public class MyRouterTest {
	@Autowired
	ProducerTemplate producerTemplate;

	@EndpointInject(uri = "mock:test")
	MockEndpoint mockEndpoint;

	@Test
	public void testCamelUnitTest() throws InterruptedException {
		mockEndpoint.expectedMinimumMessageCount(1);

		producerTemplate.sendBody("direct:foo", "Hello unit testing");

		mockEndpoint.assertIsSatisfied();
	}

}

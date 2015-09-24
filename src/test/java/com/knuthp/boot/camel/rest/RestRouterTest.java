package com.knuthp.boot.camel.rest;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.knuthp.boot.camel.GetDepartures;
import com.knuthp.boot.camel.jpa.TimerBody;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@SpringApplicationConfiguration(classes = { RestRouterTest.class, RestRouter.class })
@IntegrationTest
public class RestRouterTest {
	@Autowired
	ProducerTemplate producerTemplate;

	@EndpointInject(uri = "mock:departures")
	MockEndpoint mockEndpointDepartures;

	@Test
	public void testRuter() throws Exception {
		mockEndpointDepartures.expectedMessageCount(1);
		Processor processor = Mockito.mock(Processor.class);
		mockEndpointDepartures.whenAnyExchangeReceived(processor);

		producerTemplate.sendBody("direct:start", null);

		mockEndpointDepartures.assertIsSatisfied();
		ArgumentCaptor<Exchange> arg = ArgumentCaptor.forClass(Exchange.class);
		Mockito.verify(processor).process(arg.capture());
		GetDepartures departures = (GetDepartures) arg.getValue().getIn()
				.getBody(List.class).get(0);
		assertThat(departures.getRecordedAtTime(), startsWith("2015"));

	}
}

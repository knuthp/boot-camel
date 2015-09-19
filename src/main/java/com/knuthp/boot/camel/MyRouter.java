package com.knuthp.boot.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class MyRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer://foo?fixedRate=true&period=1000").to("direct:startJpa");
		from("direct:startJpa").to("bean:timerBody")
				.to("log:com.knuthp.boot.camel.MyRouter?level=INFO")
				.to("jpa:TimerBody?flushOnSend");

		from("timer://activiti?fixedRate=true&period=1000").to(
				"activiti:oneTaskProcess");
		from("direct:foo").to("log:com.knuthp.boot.camel.MyRouter?level=INFO")
				.to("mock:test");

		JacksonDataFormat format = new ListJacksonDataFormat();
		format.setUnmarshalType(GetDepartures.class);
		from("direct:start")
				.to("http4://reisapi.ruter.no/stopvisit/getdepartures/2200500")
				.unmarshal(format)
				.to("log:com.knuthp.boot.camel.MyRouter?level=INFO")
				.to("mock:departures");

	}
}
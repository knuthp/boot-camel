package com.knuthp.boot.camel.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class RestRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		JacksonDataFormat format = new ListJacksonDataFormat();
		format.setUnmarshalType(GetDepartures.class);
		from("direct:start")
				.to("http4://reisapi.ruter.no/stopvisit/getdepartures/2200500")
				.unmarshal(format)
				.to("log:com.knuthp.boot.camel.MyRouter?level=INFO")
				.to("mock:departures");
	}

}

package com.knuthp.boot.camel.jpa;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JpaRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:startJpa").to("bean:timerBody")
				.to("log:com.knuthp.boot.camel.MyRouter?level=INFO")
				.to("jpa:TimerBody?flushOnSend");
	}

}

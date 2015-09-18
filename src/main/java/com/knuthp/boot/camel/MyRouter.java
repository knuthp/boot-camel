package com.knuthp.boot.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer://foo?fixedRate=true&period=1000").to("bean:timerBody")
				.to("log:com.knuthp.boot.camel.MyRouter?level=INFO")
				.to("jpa:TimerBody?flushOnSend");

		from("timer://activiti?fixedRate=true&period=1000").to(
				"activiti:oneTaskProcess");

	}
}
package com.knuthp.boot.camel.activiti;

import org.apache.camel.builder.RouteBuilder;

public class ActivitiRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer://activiti?fixedRate=true&period=1000").to(
				"activiti:oneTaskProcess");
	}

}

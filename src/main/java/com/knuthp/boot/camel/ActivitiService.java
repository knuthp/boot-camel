package com.knuthp.boot.camel;

import org.activiti.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivitiService {

	private final ProcessEngine processEngine;

	@Autowired
	public ActivitiService(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

	@RequestMapping("/bootcamel/status")
	public String status() {
		return Long.toString(processEngine.getRuntimeService()
				.createProcessInstanceQuery().count());
	}

}

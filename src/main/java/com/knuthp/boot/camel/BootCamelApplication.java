package com.knuthp.boot.camel;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCamelApplication.class, args);
	}

	@Bean
	ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(
				new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}

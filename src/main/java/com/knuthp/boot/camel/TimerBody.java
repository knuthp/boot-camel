package com.knuthp.boot.camel;

import org.springframework.stereotype.Component;

@Component
public class TimerBody {

	public Customer someMethod() {
		return new Customer("A", "B");
	}

}

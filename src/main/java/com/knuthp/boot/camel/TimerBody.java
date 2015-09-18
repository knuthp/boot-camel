package com.knuthp.boot.camel;

import org.springframework.stereotype.Component;

@Component
public class TimerBody {

	public MyEntity someMethod() {
		return new MyEntity("A", "B");
	}

}

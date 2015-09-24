package com.knuthp.boot.camel.jpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@SpringApplicationConfiguration(classes = { JpaRouterTest.class,
		TimerBody.class, JpaRouter.class })
@IntegrationTest
public class JpaRouterTest {
	@Autowired
	ProducerTemplate producerTemplate;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void testJpaRoute() throws Exception {
		producerTemplate.sendBody("direct:startJpa", "");

		assertThat(customerRepository.count(), equalTo(1L));
		Iterable<Customer> findAll = customerRepository.findAll();
		assertThat(findAll.iterator().next().getFirstName(), equalTo("A"));
		assertThat(findAll.iterator().next().getLastName(), equalTo("B"));
	}
}

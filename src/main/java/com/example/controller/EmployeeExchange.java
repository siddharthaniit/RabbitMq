package com.example.controller;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.google.gson.Gson;

@RestController
public class EmployeeExchange {

	@Value("${routing-key-rabbit-mq}")
	private String routingKey;

	@Value("${search-exchange}")
	private String exchangeName;

	private RabbitTemplate rabbitTemplate;

	public EmployeeExchange(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	Employee employee = new Employee();

	@RequestMapping(value = "/exchange", method = RequestMethod.GET)
	public void exchange() {
		employee.setId(1);
		employee.setCompany("AJR");
		employee.setName("siddu");
		new Gson().toJson(employee);
		rabbitTemplate.convertAndSend(exchangeName, routingKey,employee);

	}
	
	public void save() {
		
		int i =10;
		
	}

}

package com.example.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.google.gson.Gson;

@Service
public class EmployeeQueue {

	@RabbitListener(queues = "hb-queue")
	public Employee queue(String message) {
		System.out.println(message);
		Employee fromJson = new Gson().fromJson(message, Employee.class);
		System.out.println(new Gson().toJson(fromJson));
		return fromJson;
	}

}

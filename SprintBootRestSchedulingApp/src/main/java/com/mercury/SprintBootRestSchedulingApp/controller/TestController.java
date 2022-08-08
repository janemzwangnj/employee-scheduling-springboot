package com.mercury.SprintBootRestSchedulingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.SprintBootRestSchedulingApp.service.TestService;

@Component
public class TestController {
	@Autowired
	private TestService testService;

}

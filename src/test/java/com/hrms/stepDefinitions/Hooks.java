package com.hrms.stepDefinitions;

import com.hrms.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	
	@Before
	public void beforeScenario() {
		BaseClass.setUp();
	}
	@After
	public void afterScenario() {
		BaseClass.tearDown();
}}

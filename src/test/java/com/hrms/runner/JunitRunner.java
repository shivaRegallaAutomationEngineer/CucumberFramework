package com.hrms.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".\\src\\test\\resources\\Features\\Login.feature",
glue="com.hrms.stepDefinitions",

tags= "@DataTable",
monochrome=true,
//dryRun=true
plugin= {"pretty", "html:target/html/cucumber-default-report", "json:target/cucumber.json"}
		
)

public class JunitRunner {

}

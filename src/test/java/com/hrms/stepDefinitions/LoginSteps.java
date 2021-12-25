package com.hrms.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.hrms.base.BaseClass;
import com.hrms.base.PageIntializer;
import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends PageIntializer {

	
	@Given("User open the browser and enter the url of the application")
	public void user_open_the_browser_and_enter_the_url_of_the_application() {
	   BaseClass.setUp();
	}

	@Given("User Navigates to the login page")
	public void user_navigates_to_the_login_page() {
	  System.out.println("Navigated to the loging page");
	}

	@When("User enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password() {
	  CommonMethods.sendText(loginpage.usernameBox, "Admin");
	  CommonMethods.sendText(loginpage.passwordBox, "admin123");
	}

	@When("User click on the login button")
	public void user_click_on_the_login_button() {
	  CommonMethods.clickAction(loginpage.loginBtn);
	}

	@Then("User is successfully logged in")
	public void user_is_successfully_logged_in() {
		String actualTitle=BaseClass.driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle="OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle);
	    BaseClass.tearDown();
	}
	
	
		@When("User enters valid {string} and valid {string}")
		public void user_enters_valid_and_valid(String username, String password) {
			 CommonMethods.sendText(loginpage.usernameBox, username);
			  CommonMethods.sendText(loginpage.passwordBox, password);
		}

@When("User enters invalid {string} and invalid  {string}")
public void user_enters_invalid_and_invalid(String username, String password) {
				  CommonMethods.sendText(loginpage.usernameBox, username);
				  CommonMethods.sendText(loginpage.passwordBox, password);
			
			}


@Then("verify the {string}")
			public void verify_the(String errorMessage) {
			  Assert.assertEquals(loginpage.errorMessage.getText(), errorMessage);
			   BaseClass.tearDown();
			
			}



@When("enters enters the invalid Cerdentails and click on login and verify the error")
public void enters_enters_the_invalid_cerdentails_and_click_on_login_and_verify_the_error(DataTable data) {
   List<Map<String,String>> values=   data.asMaps();
      for(Map<String,String> validation:values) {
    	  String username= validation.get("username");
    	  String password= validation.get("password");
    	  String errorMessage= validation.get("errorMessage");
    	  CommonMethods.sendText(loginpage.usernameBox, username);
		  CommonMethods.sendText(loginpage.passwordBox, password);
		  CommonMethods.clickAction(loginpage.loginBtn);
		  Assert.assertEquals(loginpage.errorMessage.getText(), errorMessage);
      }

  }






}

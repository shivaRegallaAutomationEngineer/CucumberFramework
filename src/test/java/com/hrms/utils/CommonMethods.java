package com.hrms.utils;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.base.BaseClass;



public class CommonMethods {
	public static void sendText(WebElement element,String text) {
		waitforVisibility(element);
		element.clear();
		element.sendKeys(text);
	}
	public static void clickAction(WebElement element) {
		waitforClickability(element);
	    element.click();
	}
	
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait= new WebDriverWait(BaseClass.driver,60);
	     return wait;
	}
	public static WebElement waitforClickability(WebElement ele) {
	return	getWaitObject().
		until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static WebElement waitforVisibility(WebElement ele) {
		return	getWaitObject().
			until(ExpectedConditions.visibilityOf(ele));
		}
	
	
	

}

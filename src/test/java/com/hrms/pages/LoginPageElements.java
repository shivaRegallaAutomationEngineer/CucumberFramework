package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.base.BaseClass;

public class LoginPageElements extends BaseClass{
	@FindBy(id="txtUsername")
    public WebElement usernameBox;

    @FindBy(id="txtPassword")
    public WebElement passwordBox;

    @FindBy(id="btnLogin")
    public WebElement loginBtn;

    @FindBy(id="spanMessage")
    public WebElement errorMessage;

    public LoginPageElements(){
        PageFactory.initElements(driver, this);
    }
}

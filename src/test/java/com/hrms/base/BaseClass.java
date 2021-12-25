package com.hrms.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static WebDriver setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		   switch (ConfigsReader.getProperty("BrowserName")) {
		      case "chrome":
				    WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "ie":
					WebDriverManager.iedriver().setup();
					driver = new FirefoxDriver();
					break;
				case "microsoftEdge":
					WebDriverManager.edgedriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
					throw new RuntimeException("Browser is not supported");
				}
	            driver.get(ConfigsReader.getProperty("URL"));
	            PageIntializer.intialize();
	            driver.manage().window().maximize();
	         return driver;

			}

	
	public static void tearDown() {
		driver.quit();
	}

	}


package com.amazon.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.amazon.Util.Constants;



public class BaseTest {
	BaseTest(){}
	static WebDriver driver;
	public void init(String bType){
		
		if(bType.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_EXE);
			driver = new FirefoxDriver();
					
		} else if(bType.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_EXE);
			driver = new ChromeDriver();
		}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
}

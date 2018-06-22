package com.qait.automation.tatocAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class cookiePage {
	WebDriver driver;

	
	public cookiePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void cookiePage_action()
	{
		  driver.findElement(By.linkText("Generate Token")).click();	
			String cookies=  driver.findElement(By.id("token")).getText();
			cookies = cookies.replace("Token: ", "");
			  System.out.println(cookies);
			  
			  Cookie ck = new Cookie("Token", cookies);
			  driver.manage().addCookie(ck);
			  driver.findElement(By.linkText("Proceed")).click();
	}
	public void verify_courseEnd()
	{
		String headerText=driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText();
		Assert.assertTrue(headerText.contains("End"));
	}
}

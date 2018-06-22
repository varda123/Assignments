package com.qait.automation.tatocAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homePage {
	WebDriver driver;
	@Test
	public static void newtest() {
		System.out.println("*******************************");
	}
public homePage(WebDriver driver)
{
	this.driver=driver;
}
public void homePage_action()
{
	driver.findElement(By.xpath("//a[@href='/tatoc/basic']")).click();
}
public void verify_gridPage_appeared()
{
	String headerText = driver.findElement(By.tagName("h1")).getText();
	Assert.assertTrue(headerText.contains("Grid"));
}
}

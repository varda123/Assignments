package com.qait.automation.tatocAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GridGate {
	WebDriver driver;
	public GridGate(WebDriver driver)
	{
		this.driver=driver;
	}
	public void GridGate_action()
	{
		driver.findElement(By.className("greenbox")).click();
	}
	public void verify_framePage_appeared()
	{
		String headerText = driver.findElement(By.tagName("h1")).getText();
		Assert.assertTrue(headerText.contains("Frame"));
	}
}

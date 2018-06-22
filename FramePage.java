package com.qait.automation.tatocAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FramePage {
	WebDriver driver;
	public FramePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void FramePage_action()
	{
		driver.switchTo().frame("main");
		String colormain=driver.findElement(By.id("answer")).getAttribute("class");
		System.out.println(colormain);
		driver.switchTo().frame("child");
		String colorchild=driver.findElement(By.id("answer")).getAttribute("class");
		System.out.println(colorchild);
		
		while(!(colormain.equals(colorchild)))
		{
			driver.switchTo().parentFrame();
			  driver.findElement(By.linkText("Repaint Box 2")).click();		
			driver.switchTo().frame("child");
			 colorchild=driver.findElement(By.id("answer")).getAttribute("class");
		}
		driver.switchTo().parentFrame();
		  driver.findElement(By.linkText("Proceed")).click();
	}
	public void verify_dragPage_appeared()
	{
		String headerText = driver.findElement(By.tagName("h1")).getText();
		Assert.assertTrue(headerText.contains("Drag"));
	}
	}


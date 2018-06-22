package com.qait.automation.tatocAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragPage {
	WebDriver driver;
	public DragPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void DragPage_action()
	{
		 WebElement from=driver.findElement(By.id("dragbox"));
		  WebElement to=driver.findElement(By.id("dropbox"));
		  Actions act=new Actions(driver);	
		  act.dragAndDrop(from, to).build().perform();	
		  driver.findElement(By.linkText("Proceed")).click();	
	}
	public void verify_popupPage_appeared()
	{
		String headerText = driver.findElement(By.tagName("h1")).getText();
		Assert.assertTrue(headerText.contains("Popup"));
	}
}

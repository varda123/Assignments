package com.qait.automation.tatocAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class PopupPage {
	WebDriver driver;
	public PopupPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void PopupPage_action()
	{
		 String mainWindowHandle = driver.getWindowHandle();
		 System.out.println(mainWindowHandle + " *****");
		  driver.findElement(By.linkText("Launch Popup Window")).click();
		  for (String childWindowHandle : driver.getWindowHandles()) {
			  //If window handle is not main window handle then close it 
			  System.out.println(childWindowHandle);
			  
			  if(!mainWindowHandle.equals(childWindowHandle) )
			  driver.switchTo().window(childWindowHandle);
			  System.out.println("window title is"+driver.getTitle());
			  }
		
	}
	public void verify_popupWindow_appeared()
	{
		boolean exist = false;
		 System.out.println("window title is"+driver.getTitle());
	WebElement inputField=	driver.findElement(By.cssSelector("input[type=\"text\"]"));
	System.out.println(inputField);
	if(inputField != null)
	{
		exist=true;
	}
	Assert.assertTrue(exist);
	}
}

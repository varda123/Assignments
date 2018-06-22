package com.qait.automation.tatocAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class enterNameInPopup {
	WebDriver driver;
	public enterNameInPopup(WebDriver driver)
	{
		this.driver=driver;
	}
	public void enterNameInPopup_action()
	{
			  driver.findElement(By.id("name")).sendKeys("vardasaxena");
			  driver.findElement(By.id("submit")).click();	
			 
			 // Thread.sleep(5000);
			  String childWindowHandle = driver.getWindowHandle();
			  for (String mainWindowHandle : driver.getWindowHandles()) {
				  //If window handle is not main window handle then close it 
				  System.out.println(childWindowHandle);
				  
				  if(!childWindowHandle.equals(mainWindowHandle) )
				  driver.switchTo().window(mainWindowHandle);
	
				  }
			  driver.findElement(By.linkText("Proceed")).click();	
	}
	public void verify_text_submitted()
	{
		boolean exist = false;
		WebElement proceed=  driver.findElement(By.linkText("Proceed"));
					if(proceed != null)
			{
				exist=true;
			}
			Assert.assertTrue(exist);
			}
	}


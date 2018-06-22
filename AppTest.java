package com.qait.automation.tatocAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;



public class AppTest 
{
	public WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		String exePath = "C:\\Users\\Vardasaxena\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
	    driver = new ChromeDriver();
	}
	@AfterTest
	public void afterTest() {
	//driver.close();
	}
	@Test(priority=1)
	public void openApp() {
openApp open=new openApp(driver);
open.open_page_action();
open.verifyHomePageLaunched();
	}
	@Test(dependsOnMethods={"openApp"})
	public void homePage() {
		homePage home=new homePage (driver);
		home.homePage_action();
		home.verify_gridPage_appeared();
	}
	@Test(dependsOnMethods={"homePage"})
	public void gridGate() {
		GridGate grid=new GridGate (driver);
		grid.GridGate_action();
		grid.verify_framePage_appeared();
	}
	@Test(dependsOnMethods={"gridGate"})
	public void frameDungeon() {
		FramePage frame=new FramePage (driver);
		frame.FramePage_action();	
	frame.verify_dragPage_appeared();
	}
	@Test(dependsOnMethods={"frameDungeon"})
	public void dragAround() {
		DragPage drag=new DragPage (driver);
		drag.DragPage_action();	
	drag.verify_popupPage_appeared();
	}
	@Test(dependsOnMethods={"dragAround"})
	public void popupWindow() {
		PopupPage drag=new PopupPage (driver);
		
		drag.PopupPage_action();	
		drag.verify_popupWindow_appeared();
	}
	@Test(dependsOnMethods={"popupWindow"})
	public void newWindow() {
		 enterNameInPopup name=new  enterNameInPopup(driver);
		 name. enterNameInPopup_action();
	}
@Test(dependsOnMethods={"newWindow"})
	public void cookiePage() {
		 cookiePage cookie=new   cookiePage(driver);
		cookie. cookiePage_action();
		cookie.verify_courseEnd();
			  
	}
   

}

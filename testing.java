package tatocassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class testing {
	public static void main(String args[]) throws InterruptedException
	{
		String exePath = "C:\\Users\\Vardasaxena\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
	WebDriver driver = new ChromeDriver();
	driver.get("http://10.0.1.86/tatoc");
	
	driver.findElement(By.xpath("//a[@href='/tatoc/basic']")).click();
	
	driver.findElement(By.className("greenbox")).click();
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
	  WebElement from=driver.findElement(By.id("dragbox"));
	  WebElement to=driver.findElement(By.id("dropbox"));
	  Actions act=new Actions(driver);	
	  act.dragAndDrop(from, to).build().perform();	
	  driver.findElement(By.linkText("Proceed")).click();		
	 String mainWindowHandle = driver.getWindowHandle();
	 System.out.println(mainWindowHandle + " *****");
	  driver.findElement(By.linkText("Launch Popup Window")).click();	
	  for (String childWindowHandle : driver.getWindowHandles()) {
		  //If window handle is not main window handle then close it 
		  System.out.println(childWindowHandle);
		  
		  if(!mainWindowHandle.equals(childWindowHandle) )
		  driver.switchTo().window(childWindowHandle);
		 
		 
		
		  }
		  driver.findElement(By.id("name")).sendKeys("vardasaxena");
		  driver.findElement(By.id("submit")).click();	
		 
		 // Thread.sleep(5000);
		  driver.switchTo().window(mainWindowHandle);
		  driver.findElement(By.linkText("Proceed")).click();	
		  driver.findElement(By.linkText("Generate Token")).click();	
		String cookies=  driver.findElement(By.id("token")).getText();
		cookies = cookies.replace("Token: ", "");
		  System.out.println(cookies);
		  
		  Cookie ck = new Cookie("Token", cookies);
		  driver.manage().addCookie(ck);
		  driver.findElement(By.linkText("Proceed")).click();
		  
		
		  
		} 
	}


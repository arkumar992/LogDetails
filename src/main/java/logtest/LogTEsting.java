package logtest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LogTEsting {
	
	
	public static WebDriver driver;
	
	Logger logg = Logger.getLogger("LogTEsting.class");

	 
	
	@BeforeMethod
	
	public  void initi()
	{
	
	System.setProperty("Webdriver.chrome.driver", "/home/pixintdev/Downloads/chromedriver");
	  driver = new ChromeDriver();
	  
	  logg.info("launching browser");
	  
	  
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);  
	   
	  driver.get("https://www.ultimatix.net/");
	  logg.info("url loading");
	  driver.navigate().refresh();	
	  logg.warn("waring message");
	  
	  logg.fatal("this is fatal message");
	  
	  logg.debug("test debugged");
	}
	
	
	@Test
	
	public  void title()
	
	
	{
		logg.info("*********************testlog***************************");
		logg.info("*********************started***************************");
		System.out.println("Title is " + driver.getTitle());
	}
	
	@Test
	
	public  void title_test() {
		
		logg.info("*********************testlog***************************");
		logg.info("*********************started***************************");
		System.out.println("test completed");
		
	}
	  

	@AfterMethod
	public void close() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}

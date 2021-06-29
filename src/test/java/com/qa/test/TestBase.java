package com.qa.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.PagalWorldPages;

public class TestBase {
	WebDriver driver;
	PagalWorldPages world;
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void SetUp(String Browser,String Url) throws InterruptedException
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vrodg\\OneDrive\\Desktop\\Selenium_SW\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			//driver.manage().window().maximize();
		}
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vrodg\\OneDrive\\Desktop\\Selenium_SW\\geckodriver-v0.29.1-win32\\geckodriver.exe");
			driver=new FirefoxDriver();
			//driver.manage().window().maximize();
		} 
		driver.manage().window().maximize();

		world = new PagalWorldPages(driver);
		driver.get(Url);
		
		
	}
	@AfterClass
	public void TearDown()
	{
	 driver.quit();
		
	}
	public void captureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File Source = screenshot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
		FileUtils.copyFile(Source, new File(Dest));
		
	}
}

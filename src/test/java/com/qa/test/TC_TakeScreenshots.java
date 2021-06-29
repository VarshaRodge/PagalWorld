package com.qa.test;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TC_TakeScreenshots extends TestBase
{
	@Test(priority=1, groups = {"ScreenShots"})
	public void screenshotOfElement() throws IOException
	{
		File Source = driver.findElement(By.xpath("/html/body/header/a/img")).getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+"PagalWorld.png";
		FileUtils.copyFile(Source, new File(Dest));
		
	}
	@Test(priority=2, groups = {"ScreenShots"})
	public void screenshotOfDriver() throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File Source = screenshot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+"PagalWorldPage.png";
		FileUtils.copyFile(Source, new File(Dest));
		
	}
	@Test(priority=3, groups = {"ScreenShots"})
	public void screenshotOfFullPage() throws IOException
	{
		AShot SShot = new AShot();
		Screenshot Source = SShot.shootingStrategy(ShootingStrategies.viewportPasting(300)).takeScreenshot(driver);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+"PagalWorldFullPage.jpg";
		ImageIO.write(Source.getImage(),"jpg",new File(Dest));
		
	}
	
}

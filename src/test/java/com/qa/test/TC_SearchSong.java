package com.qa.test;

import java.io.IOException;
import java.security.Key;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_SearchSong extends TestBase {
	@Test(dataProvider="getData",priority= 2, groups = {"SearchbarTest"})
	public void SearchItem(String SongName) throws InterruptedException, IOException
	{
		 world.getsearchtextbox().sendKeys(SongName);
		 Thread.sleep(2000);
		 world.getSearch().click();
		 Thread.sleep(1000);
		 
		 List<WebElement> songs=world.getSearchBoxItem(); 
		 int count = songs.size();
		 Thread.sleep(1000);
		 
		 Assert.assertTrue(count<=50);
	     //Assert.assertEquals(options.size(),50);
		
		 if(count>0)
		 {
			 Reporter.log("Total no of songs loaded are:"+count);
             for (WebElement song:songs)
	          {
	         	  Reporter.log(song.getText());
	          }
			 Reporter.log(driver.getTitle()+":----> this song is available",true);
			 Assert.assertTrue(true);
         }
		 else
		 {
			 captureScreenshot(driver,"SearchItem");
			 Reporter.log(driver.getTitle()+":----> this song is not available",true);
			 Assert.assertTrue(false);
		 }
		 //world.getsearchtextbox().clear();

	}
	
	@Test(priority=1, groups = {"HomePageTest"})
	public void getAvailableSongs() throws InterruptedException
	{
	 Reporter.log("New Available Songs : ");
	 List<WebElement> songs=world.getList1(); 
	 Reporter.log("Total no of songs available are : "+songs.size());
	 Thread.sleep(1000);
	 Assert.assertTrue(songs.size()<=50);
	 for (WebElement song:songs)
      {
     	  Reporter.log(song.getText());
      }
	
	}
	
	@DataProvider
	public String[][] getData() throws IOException
	{
		String xFile = "C:\\Users\\vrodg\\eclipse-workspace\\PagalWorld\\src\\test\\java\\com\\qa\\testdata\\SongInput.xlsx";
		String xSheet="Sheet1";
		int rowCount=ExcelUtility.getRowConut(xFile, xSheet);
		int cellCount =ExcelUtility.getCellCount(xFile, xSheet, rowCount);
		
		String[][] data=new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		return data;
     }
	
	
	

}

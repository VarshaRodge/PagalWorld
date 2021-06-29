package com.qa.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_getPanjabiSongs extends TestBase
{
	@Test(groups = {"HeaderLinkTest"})
	public void getAllPanjabiSongs()
	{
		 world.getPanjabiSong().click();
		 List<WebElement> Songs=world.getPanjabiSongs(); 
		 Reporter.log("Total no of Panjabi songs available are :"+ Songs.size());
         for (WebElement  Song: Songs)
          {
        	  Reporter.log(Song.getText());
          }
		
	}

}

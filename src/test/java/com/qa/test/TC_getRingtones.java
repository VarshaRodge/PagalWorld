package com.qa.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_getRingtones extends TestBase
{
	@Test(groups = {"HeaderLinkTest"})
	public void GetAllRingTones()
	{
		 world.getRingtones().click();
		 List<WebElement> Ringtones=world.getRings(); 
		 Reporter.log("Total no of Ringtones available are :"+ Ringtones.size());
         for (WebElement  Ringtone: Ringtones)
          {
         	  Reporter.log(Ringtone.getText());
          }
		
	}

}

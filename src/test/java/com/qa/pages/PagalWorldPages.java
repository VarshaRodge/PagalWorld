package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PagalWorldPages {
	WebDriver driver;
	
	@FindBy(name ="find")
	WebElement searchtextbox;
	public WebElement getsearchtextbox()
	 {
		return searchtextbox;	
	 }
	
	@FindBy(xpath ="/html/body/nav/a[6]")
	WebElement Ringtones;
	public WebElement getRingtones()
	 {
		return Ringtones;	
	 }

	 @FindBy(xpath ="/html/body/main/div[7]/div/div[1]")
	 WebElement Download;
	 public WebElement getDownload()
	 {
			return Download;	
	 }

	
	@FindBy(xpath ="/html/body/nav/div/form/button")
	WebElement Search;
	public WebElement getSearch()
	 {
		return Search;	
	 }
	@FindBy(className ="desc")
	List<WebElement>  SearchBoxItem;
	public List<WebElement> getSearchBoxItem()
	 {
		return SearchBoxItem;	
	 }
	
	@FindAll(@FindBy(xpath ="/html/body/main/div[6]/ul/li"))
	List<WebElement> List1;
	public List<WebElement> getList1()
	 {
		return List1;	
	 }
	
	@FindAll(@FindBy(xpath ="//*[@id=\"cateogry\"]/div[2]/div/ul/li"))
	List<WebElement> Rings;
	public List<WebElement> getRings()
	 {
		return Rings;	
	 }
	@FindBy(xpath ="/html/body/nav/a[1]")
	WebElement PanjabiSong;
	public WebElement getPanjabiSong()
	 {
		return PanjabiSong;	
	 }

	@FindAll(@FindBy(xpath ="/html/body/main/div[5]/ul/li"))
	List<WebElement> PanjabiSongs;
	public List<WebElement> getPanjabiSongs()
	 {
		return PanjabiSongs;	
	 }
	
	public PagalWorldPages(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

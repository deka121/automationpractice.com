package com.msp.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Created by Dhruba Deka  on 29/07/2019.
 */
public class HomePage {
	
	 public HomePage(WebDriver driver) throws Exception
	 {
		 PageFactory.initElements(driver, this);
	  }
	
	@FindBy(className="login")
	WebElement txtlogin;
	
	//method to click on singin button from home page
	public void singin()
	{
		this.txtlogin.click();
	}
	


}

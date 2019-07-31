package com.msp.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.msp.framework.base.TestBase;

/**
 * Created by Dhruba Deka  on 29/07/2019.
 */

public class LogoutPage extends TestBase {
	
	 public LogoutPage(WebDriver driver) throws Exception
   	 {
		 PageFactory.initElements(driver, this);
	  }
	 
	 @FindBy(how = How.CLASS_NAME, using = "logout")
	  public WebElement SignOutBtn;
	
// method to verify  logout button
		 public void logout()
		 {
			this.SignOutBtn.click();
		 }
		 
// method to verify  logout page
      	public void Logout_Page()
		  {
		     String title= driver.getTitle();
			 System.out.println("Title is"+title);
			 if(title.equals("Login - My Store"))
			{ System.out.println("Logout Page is displaying");
			} else
			{System.out.println("Logut Page not available");
		 }	  			
		 }
}

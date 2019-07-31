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

public class LoginPage extends TestBase {
	
	 public LoginPage(WebDriver driver) throws Exception
	 {
		 PageFactory.initElements(driver, this);
	  }
	 
	 @FindBy(how = How.ID, using = "email")
	  public WebElement txtEmailaddress;
	  
	  @FindBy(how = How.NAME, using = "passwd")
	  public WebElement txtPassword;
	  
	  @FindBy(how = How.NAME, using = "SubmitLogin")
	  public WebElement txtSignin;

//method to verify LogIn from My-Store Login Page
	  public void Enterlogindetails()
	  { 
		 txtEmailaddress.sendKeys(prop.getProperty("email"));
		 txtPassword.sendKeys(prop.getProperty("old_passwd"));
	  }
 
//method to verify SingIn link from My-Store Home Page
	 public void SingIn()
	 {
		 txtSignin.click();
	 }
 
 //method to verify My Account Summery Page
	 public void MyAccountSummaryPage(WebDriver driver)
	 {
		 String title= driver.getTitle();
		 System.out.println("Title is"+title);
	     if(title.equals("My account - My Store"))
		{ System.out.println("My account - My Store Page is displaying");
		}else
		{ System.out.println("My account - My Store Page not is displaying ");
		}
	 }
}




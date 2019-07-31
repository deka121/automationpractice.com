package com.msp.framework.pages;

import java.io.FileOutputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.msp.framework.base.TestBase;

public class PersonaldetialsPage extends TestBase {
	/**
	 * Created by Dhruba Deka  on 30/07/2019.
	 */
	
	 public PersonaldetialsPage(WebDriver driver) throws Exception
	 {
		 PageFactory.initElements(driver, this);
	  }
	
	@FindBy(xpath="//a[@title ='Information']")
	public WebElement MyPIbtn;
	
	@FindBy(xpath="//a[@title='Manage my personal information']")
	public WebElement Manage_my_personal_information;
	
	@FindBy(name="firstname")
	public WebElement txtFirstname;
	
	@FindBy(name="submitIdentity")
	public WebElement Submitbtn;
	
	@FindBy(id = "old_passwd")
	public  WebElement textOldPassword;

	@FindBy(id = "passwd")
	public WebElement textNewPassword;
	
	@FindBy(id = "confirmation")
	public WebElement textConfirmation;
	
	@FindBy(xpath="//p[@class=\"alert alert-success\"]")
	public WebElement successMessage;
	
		
	//All Methods
	
	//method to verify manage my personal infrmation section
	public void Manage_my_personal_information()
	{
		this.Manage_my_personal_information.click();
	}
	//method to verify firstname field
	 public void firstname(String Firstname)
	 {	 
		 txtFirstname.clear();
		 txtFirstname.sendKeys(Firstname);	 
	 }
	
		//method to verify change password  field
		public void ChangePassword() throws IOException
		 {		 
		 textOldPassword.sendKeys(prop.getProperty("old_passwd"));
		 textNewPassword.sendKeys(prop.getProperty("passwd"));	
		 textConfirmation.sendKeys(prop.getProperty("confirmation"));
			 
		FileOutputStream fio= new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\msp\\framework\\config\\cofig.properties");
		prop.setProperty("old_passwd", prop.getProperty("passwd"));
		prop.store(fio, null);
		fio.close();		 
		 }
		//method to click on Submit button
		public void Submitbtn()
		{
		  this.Submitbtn.click();
		}
				
		//method to verify the message		
		public void verifyMessage() 
		{
		String title= successMessage.getText();
		System.out.println("Title is"+title);
		 }	
					 
}





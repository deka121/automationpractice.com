package com.msp.framework.stepdefinition;

import com.msp.framework.base.TestBase;
import com.msp.framework.pages.HomePage;
import com.msp.framework.pages.LoginPage;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

/**
 * Created by Dhruba Deka  on 29/07/2019.
 */
public class LoginStep extends TestBase {
	
	 @When("^I enter EmailAddress and Password$")
    public void i_enter_emailaddress_and_password() throws Exception
    {
     	LoginPage loginpage = new LoginPage(driver);
    	loginpage.Enterlogindetails();   
    }

	@Then("^I click Signin link$")
	public void i_click_signin_link() throws Exception
	  {
		 HomePage home = new HomePage(driver);		
		 home.singin();
	   }
	 
	@Then("^I click Sign in button$")
	 public void i_click_sign_in_button() throws Exception 
	    {
	    	LoginPage loginpage = new LoginPage(driver);
	    	loginpage.SingIn();
	    }
 
	@Then("^I see the My Account page$")
	    public void i_see_the_my_account_page() throws Exception 
	    {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.MyAccountSummaryPage(driver);
	    }
}
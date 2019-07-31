	package com.msp.framework.pages;
	
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import com.msp.framework.base.TestBase;
	
	/**
	 * Created by Dhruba Deka  on 30/07/2019.
	 */	
	public class OrderPage extends TestBase{
	public OrderPage(WebDriver driver) throws Exception
				 {
			 PageFactory.initElements(driver, this);
				 }
		
		 @FindBy(xpath="(//a[text()='T-shirts'])[last()]")
		  public WebElement TShirtslnk;
				
		 @FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
		 public	 WebElement AddToCartbtn;
				 
		 @FindBy(xpath="//a[@title='Proceed to checkout']")
		 public  WebElement ProceedToChkOutBtn;
				 
		 @FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
		 public  WebElement ProceedToChkOutBtn1;
		
		 @FindBy(name="processAddress")
		 public  WebElement ProceedToChkOutBtn2;
				 
		 @FindBy(xpath="//input[@type='checkbox']")
		 public WebElement Checkbox;
				 
		 @FindBy(xpath="//button[@name='processCarrier']")
		 public  WebElement ProceedToChkOutBtn3;
				 
		 @FindBy(xpath="//a[@class='bankwire']")
		 public  WebElement BankWirePaymentTab ;
				 
		 @FindBy(xpath="//button[@class='button btn btn-default button-medium']")
		 public  WebElement ConfirmOrderbtn;
				 
		 @FindBy(xpath="//strong[contains(text(),'Your order on My Store is complete.')]")
		 public  WebElement YourOrder;
				 
		 @FindBy(xpath="//a[@class='button-exclusive btn btn-default']")
		 public  WebElement BackToOrderslnk;
				 
		 @FindBy(xpath="//h1[contains(text(),'Order history')]")
		 public  WebElement OrderHistory;
				 
		 @FindBy(xpath="//div/h1[contains(text(),'Shopping-cart summary')]")
		 public  WebElement ShopCartSumyPage;
		 
		 @FindBy(xpath="//*[@id='columns']/div[1]/span[2]")
		 public  WebElement AddressesPage;
				
		 @FindBy(xpath="//span[@class='navigation_page']")
		 public  WebElement ShippingSectn;
				
		 @FindBy(xpath="//span[@class='navigation_page']")
		 public  WebElement PaymentSectn;
			
		 @FindBy(xpath="//span[@class='navigation_page']")
		 public  WebElement  OrderSumryPg;				 
		
		 @FindBy(xpath=" //*[@id='center_column']/ul/li[1]/a/span")
		 public  WebElement  BackBtn;
		  
 	 //All Methods 
		 
   //Method to  verify the Sroll down & T-shirts My-Store Page existance 
	  public void MyTshirtStorePage(WebDriver driver) throws InterruptedException
		 {
	      String title= driver.getTitle();
		  System.out.println("Title is"+title);
		  if(title.equals("T-shirts - My Store"))
		  { System.out.println("Page verified ");
			}else
		   {System.out.println("Page not available");
		   }
		 }

	 //method to  verify the presence of purchase order in order history page
	 public void VerifyPurchasOrder(WebDriver driver)
			 {
	      	String s = driver.findElement(By.xpath("//div[@class='box']")).getText();
			String[] items = s.split("-");
			String orderPlaced = items[5].substring(46, 55);
			System.out.println("orderPlaced: "+orderPlaced);
			driver.findElement(By.xpath("//a[@title='Back to orders']")).click();
			String orderHistory =driver.findElement(By.xpath("//a[contains(text(),'"+orderPlaced+"')]")).getText();
			System.out.println("orderHistory: "+orderHistory);
			if(orderPlaced.equals(orderHistory))
					{
						 System.out.println("Purchase Order is Present in Order History Page ");
					}	else
					{
						System.out.println("Purchase Order is not Present Order History Page");
					}
			  }
	 
		//method for Mouse Hover 
		 public void  Add_To_Cartbtn(WebDriver driver ) 
		 {
		 Actions action = new Actions(driver);
		 action.moveToElement(driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"))).build().perform();	
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
		 }		
	 //method to verify  shopping cart summary page
		 public void  Shop_CartSumyPage() {
		 String bodyText = ShopCartSumyPage.getText();
		 if(bodyText.equals("Your shopping cart"))
		 { System.out.println("shopping cart summary page is  successfully displaying");
		 }else
		 { System.out.println("shopping cart summary page is not displaying");		 
		 }
	 	 }
		//method to verify address section
		public void  Address_Page() {
		String bodyText = AddressesPage.getText();
		if(bodyText.equals("Addresses"))
		 {System.out.println("Addresses page is successfully displaying ");
		 } else
		 { System.out.println("Addresses Page is not displaying");
		 }	  
		 }
	 // method to verify  to the shipping section
	     public void  Shipping_Sectn() {
		 String bodyText = ShippingSectn.getText();
		 if(bodyText.equals("Shipping"))
		 { System.out.println(" Shipping page is successfully displaying ");
		 }else
		{ System.out.println("Shipping page is  not displaying");
		 }	  
		 }				 	  	 
		// method to verify  to the payment section
		 public void  Payment_Sectn() {
		 String bodyText = PaymentSectn.getText();
		 if(bodyText.equals("Your payment method"))
		 { System.out.println("Your payment method page is successfully displaying");
		 }else
		 { System.out.println("Your payment method page is  not displaying");
		  }	  
		 }			  	
	   // method to verify order summary page
		public void  Order_Sumry_Pg() {
	    String bodyText = OrderSumryPg.getText();
		 if(bodyText.equals("Bank-wire payment."))
		{ System.out.println("Bank-wire payment section is successfully displaying");
		}else
		{ System.out.println("Bank-wire payment section is  not displaying");
		}
		}		
		//method to verify order confirmation page
		 public void  Ordertext() {
		 String bodyText = YourOrder.getText();
		  if(bodyText.equals("Your order on My Store is complete."))
		 { System.out.println("Your order on My Store is complete page is successfully displaying");
		 }else
		 { System.out.println("Your order on My Store is complete page is not displaying");
		 }
		 }	
		// method to verify Order history page
		 public void  OrderHistory() {
		 String bodyText = OrderHistory.getText();
		 if(bodyText.equals("Order history"))
		 { System.out.println("Order history page is successfully displaying");
		 }else
		 { System.out.println("Order history page is not displaying");
		 }
		 }
		 //method for T-Shirts link	 
		public void Click_on_Tshirtlnk()
		{
		this.TShirtslnk.click();
		}
		
		//method for Proceed Checkout button from  cart window
		public void Proceed_To_ChkOutBtn()
		 {
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", ProceedToChkOutBtn);
 		 }
			
    	//method for Proceed Checkout button cart from summary page
	  	 public void Proceed_To_ChkOutBtn1()
		{
		this.ProceedToChkOutBtn1.click();
		}
		//method for Proceed to checkout button from address section
		public void Proceed_To_ChkOutBtn2()
		{
		this.ProceedToChkOutBtn2.click();
		}
	     //method for Terms of service checkbox button shipping section
		public void Click_On_Checkbox()
		{
		this.Checkbox.click();
		}
		//method for  checkout button shipping section
		public void Proceed_To_ChkOutBtn3()
		{
		this.ProceedToChkOutBtn3.click();
		}
		//method for bank wire payment option
		public void BankWirePayment_Tab()
		{
		this.BankWirePaymentTab.click();
		}
		//I click on confirm my order button
		public void ConfirmOrder()
		{
		this.ConfirmOrderbtn.click();
		}
		//method for  Back to your account button
		public void Back_To_Myaccount()
		{
		this.BackBtn.click();
		}						
}


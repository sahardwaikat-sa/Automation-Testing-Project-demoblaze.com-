package TestPages;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import Base.BasePage;
import Pages.WorkFlow1Page;

public class WorkFlow1Test extends BasePage{
		
	   
		WorkFlow1Page WorkFlow1;
		WebDriverWait wait;
		
	
	@BeforeMethod
	void setUpObject() {
	WorkFlow1= new WorkFlow1Page(driver);
	 wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
		
	}
	
	@Test(priority=1)
	void verifyLoginClick() {
	  WorkFlow1.loginClick();
        Assert.assertTrue(WorkFlow1.logintext().contains("Log in"));
    	WorkFlow1.userLogin("sahar","1234");
    	    	  	
    	Assert.assertTrue(WorkFlow1.welcomeUser().contains("Welcome sahar"));
    	
	}
	@Test(priority=2)
	void verifyselectItem1() {	
		WorkFlow1.selectItem1();
	Assert.assertTrue(WorkFlow1.productDescription());
	   WorkFlow1.addToCard();}
	   
	 @Test
	 void verifyAddCart() {
		 WorkFlow1.selectItem1();
		 WorkFlow1.addToCard();
		 
		 Alert alert =wait.until(ExpectedConditions.alertIsPresent());
		String actual= alert.getText();
		
		Assert.assertTrue(actual.contains("Product added"));
		 alert.accept();
		 
		 
	 }

	
	
	@Test(priority=4)
  void verifyCart() {
	  
	 // WorkFlow1.loginClick();
	  	WorkFlow1.cartClick();
	  	
	Assert.assertEquals(WorkFlow1.cartTotalPrice(),WorkFlow1.totalPrice());
	 }
	

	
	
	  

@Test(priority=5,dataProvider = "CustomerInfo",dataProviderClass = TestingData.class)

  void verifyPlaceOrder ( String name , String country, String City,  String creditcard, String month, String year, String message) {
	WorkFlow1.cartClick();
	
	WorkFlow1.placeOrderClick() ;
	
	WorkFlow1.placeOrder( name,  country, City, creditcard,  month,  year) ;
	
	WorkFlow1.purchaseClick();
	
	 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		  

		    String actualMessage = alert.getText();

		   
			Assert.assertEquals(actualMessage, message);

		    alert.accept();
}


}




	
	
	



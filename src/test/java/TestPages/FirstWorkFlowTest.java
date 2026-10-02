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
import Pages.CartPage;
import Pages.FirstWorkFlowPage;
import Pages.ItemsPage;
import Pages.OrderPlacePage;

public class FirstWorkFlowTest extends BasePage{
		
	   
		FirstWorkFlowPage WorkFlow1;
		ItemsPage         ItempageObj;
		CartPage          CartPageObj;
		OrderPlacePage    OrderPlaceObj;
		WebDriverWait     wait;
		
		String username       = "sahar";
		String pass           = "1234";
		String WelcomeMesg    ="Welcome sahar";
		String FirstItem      = "Samsung galaxy s6";
		String SecondItem     ="Sony vaio i5";
		String OrderPlaceMesg = "Thank you for your purchase!";
		
		
	
	@BeforeMethod
	void setUpObject() {
	WorkFlow1= new FirstWorkFlowPage(driver);
	ItempageObj = new ItemsPage (driver);
	CartPageObj = new CartPage (driver);
	OrderPlaceObj = new OrderPlacePage (driver);
	wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
		
	}
	
	@Test(priority=1)
	void verifyLoginClick() {
	  WorkFlow1.loginClick();
        Assert.assertTrue(WorkFlow1.logintext().contains("Log in"));
    	WorkFlow1.userLogin(" username",pass);
    	    	  	
    	Assert.assertTrue(ItempageObj.welcomeUser().contains("WelcomeMesg"));
    	
	}
	@Test(priority=2)
	void verifyselectItem1() {	
		
		Assert.assertTrue(ItempageObj.selectItem1().contains (FirstItem));
	Assert.assertTrue(ItempageObj.productDescription());}
	
	@Test(priority=3)
	
		void verifyselectItem2() {	
		
		Assert.assertTrue(ItempageObj.selectItem2().contains (SecondItem));
	Assert.assertTrue(ItempageObj.productDescription());}
	 
	
	
	@Test(priority=4)
	 void verifyAddCart() {
		ItempageObj.selectItem1();
       Assert.assertTrue(ItempageObj.addToCard().contains("Product added"));
       }
		
	
	@Test(priority=5)
    void verifyCartPrice() {
	  
	 // WorkFlow1.loginClick();
		CartPageObj.cartClick();
	  	
	Assert.assertEquals(CartPageObj.cartTotalPrice(),ItempageObj.totalPrice());
	 }
	

	
	
	  

@Test(priority=7,dataProvider = "CustomerInfo",dataProviderClass = TestingData.class)

  void verifyPlaceOrder ( String name , String country, String City,  String creditcard, String month, String year, String message,boolean expected) {
	CartPageObj.cartClick();
	
	CartPageObj.placeOrderClick() ;
	
	OrderPlaceObj.placeOrder( name,  country, City, creditcard,  month,  year) ;
	
	OrderPlaceObj.purchaseClick();
	
	if (expected ) {
		
		Assert.assertTrue(message.contains(OrderPlaceMesg));}
	else {  
		
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		String Message=alert.getText();
		alert.accept();
		Assert.assertTrue(message.contains(Message));
		
	}
}


}




	
	
	



package TestPages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.BasePage;
import Pages.CartPage;
import Pages.FirstWorkFlowPage;
import Pages.ItemsPage;
import Pages.SignUpPage;
import Pages.SecondWorkFlowPage;


public class SecondWorkFlow extends BasePage {
	
	
	SecondWorkFlowPage WorkFlow2Obj;
	ItemsPage         ItempageObj;
	CartPage          CartPageObj;
	SignUpPage       SignUpObj;
	WebDriverWait wait;

	FirstWorkFlowPage WorkFlow1;
	

@BeforeMethod
void setUpObject() {
	WorkFlow2Obj= new SecondWorkFlowPage(driver);
	WorkFlow1= new FirstWorkFlowPage(driver);
	ItempageObj = new ItemsPage (driver);
	CartPageObj = new CartPage (driver);
	SignUpObj  = new SignUpPage(driver);
    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    

}


@Test (priority=1, dataProvider = "SignUpUsers",dataProviderClass = TestingData.class )
void  verifySignUp(String username,String Pass,String expected){
	SignUpObj .signupClick();
	SignUpObj .userSignUp(username ,Pass);
	SignUpObj .signUP();
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	
	String actual =alert.getText();
	if (expected.equals("true")) {
	Assert.assertTrue(actual.contains("Sign up successful."));}
	
	else { 
		Assert.assertTrue(actual.contains("This user already exist."));
	}
	alert.accept();
}



@Test(priority=2)
void verifyLoginClick() {
   WorkFlow1.loginClick();
    Assert.assertTrue(WorkFlow1.logintext().contains("Log in"));
	WorkFlow1.userLogin("sahar","1234");
	    	  	
	Assert.assertTrue(ItempageObj.welcomeUser().contains("Welcome sahar"));
	
}
@Test(priority=3)
void veryfiyLaptopCategoriesClick() {

	ItempageObj.laptopCategoriesClick();
	Assert.assertTrue(ItempageObj.laptopIsDisplayed());
	WorkFlow2Obj.nextClick();
	WorkFlow2Obj.previousClick();
	
}
@Test(priority=4)
void verifyLaptopCategoriesNext()
{
	ItempageObj.laptopCategoriesClick();
    WorkFlow2Obj.nextClick();
    ItempageObj.asusIsDisplayed();

	Assert.assertTrue(ItempageObj.asusIsDisplayed());
	System.out.println("Laptop products are displayed and products from other categories are  displayed(ASUS).");}

@Test(priority=5)
  void verifyContactNavigation() {
	WorkFlow2Obj.contactClick();
	Assert.assertTrue(WorkFlow2Obj.contactNameIsDisplayed());
	
}



@Test (priority=6, dataProvider = "Contact",dataProviderClass = TestingData.class )
void verifyContactTemplat(String email, String name ,String message, String expected) {
	
	WorkFlow2Obj.contact(email, name, message);
	WorkFlow2Obj.sendContactMessage();
	
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	
	String actual = alert.getText();
	if(expected.equals(actual)) {
		
		Assert.assertTrue(actual.contains("Thanks for the message!!"));
		
	}
	alert.accept();
}
	


	@Test(priority=7)
	void verifyEmptyCart () {
		
		CartPageObj.cartClick();
		Assert.assertEquals(WorkFlow2Obj.emptyCart(), 0);
		System.out.println("the cart is Empty , no item selected");
		CartPageObj.placeOrderClick();
		Assert.assertTrue(WorkFlow2Obj.checkoutIsDisplayed());
		
	
	
	
}
}

package TestPages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BasePage;
import Pages.WorkFlow1Page;
import Pages.WorkFlow2;


public class WorkFlow2Test extends BasePage {
	
	
	WorkFlow2 WorkFlow2Obj;
	WebDriverWait wait;

	WorkFlow1Page WorkFlow1;
	

@BeforeMethod
void setUpObject() {
	WorkFlow2Obj= new WorkFlow2(driver);
	WorkFlow1= new WorkFlow1Page(driver);
    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    

}


@Test (priority=1, dataProvider = "SignUpUsers",dataProviderClass = TestingData.class )
void  verifySignUp(String username,String Pass,String expected){
	 WorkFlow2Obj.signupClick();
	WorkFlow2Obj.userSignUp(username ,Pass);
	WorkFlow2Obj.signUP();
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
	    	  	
	Assert.assertTrue(WorkFlow1.welcomeUser().contains("Welcome sahar"));
	
}
@Test(priority=3)
void veryfiyLaptopCategoriesClick() {

	WorkFlow2Obj.laptopCategoriesClick();
	Assert.assertTrue(WorkFlow2Obj.laptopIsDisplayed());
	WorkFlow2Obj.nextClick();
	WorkFlow2Obj.previousClick();
	WorkFlow2Obj.contactClick();
}
@Test (priority=4, dataProvider = "Contact",dataProviderClass = TestingData.class )
void verifyContactTemplat(String email, String name ,String message, String expected) {
	
	WorkFlow2Obj.contact(email, name, message);
	WorkFlow2Obj.sendContactMessage();
	
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	
	String actual = alert.getText();
	if(expected.equals(actual)) {
		
		Assert.assertTrue(actual.contains("Thanks for the message!!"));
	}
	
}
}

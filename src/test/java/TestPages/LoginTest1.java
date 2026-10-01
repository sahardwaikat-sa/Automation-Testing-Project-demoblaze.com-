package TestPages;

import java.time.Duration;

import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasePage;
import Pages.loginPage1;


public class LoginTest1 extends BasePage {

    loginPage1 loginObject;
	WebDriverWait wait;
	
    @BeforeMethod
    public void setupObject() {
    	loginObject = new loginPage1(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginObject.clickLoginmain();
        
    }

    @Test(dataProvider = "LoginData",dataProviderClass = TestingData.class)
    public void verifyLogin(String username, String password, String expected) {
    	 loginObject.enterUsername(username);
        loginObject.enterPassword(password);
        loginObject.clickLogin();
     
        if (expected.equals("true")) {
        	Assert.assertTrue(loginObject.welcomeUser().contains("Welcome "+username));}
                 
        else if (expected.equals("false")) {
         
        
		  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        	

        		// 6. Verify message
        		String actualMessage = alert.getText();

        		Assert.assertTrue(actualMessage.contains("Wrong password."));

        		alert.accept();    }
        
        
  else {
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	  String Message = alert.getText();

    	    Assert.assertTrue(Message.contains("Please fill out Username and Password"));
    	    
    	    alert.accept();
    }
    }
}


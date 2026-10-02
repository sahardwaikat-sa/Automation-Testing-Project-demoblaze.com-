package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstWorkFlowPage {

	WebDriver driver;
	WebDriverWait wait;
	
	// Locaters 
	
	By SignupButton  = By.xpath("//a[@class='nav-link' and text()='Sign up']");
	By LoginButton   = By.xpath("//a[@class='nav-link' and text()='Log in']");
	By SignUpLabel   = By.xpath("//h5[@class='modal-title'and text()='Sign up']");
	By UsernameInput = By.xpath("//input[@id='sign-username']");
	By PasswordInput = By.xpath("//input[@id='sign-password']");
	By SignupButton2 = By.xpath("//Button[@onclick='register()'and text()='Sign up']");
	By CloseButton   = By.xpath("");
	By LoginLabel    = By.xpath("//h5[@id='logInModalLabel']");
	By loginUsername = By.xpath("//input[@id='loginusername']");
	By loginPass     = By .xpath("//input[@id='loginpassword']");
	By loginbutton2  = By.xpath("//button[@onclick='logIn()']");
	

	
	// Constructer
	
	
 public FirstWorkFlowPage(WebDriver driver) {
		
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	


public void loginClick () {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(LoginButton)).click();
}

public void login2Click () {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(loginbutton2)).click();
}

  public void userLogin(String username,String pass) {
	  
	 wait.until(ExpectedConditions.visibilityOfElementLocated(loginUsername)).sendKeys(username);
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(loginPass)).sendKeys(pass);
	 login2Click ();
  }

	

public String logintext() {
	
	return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLabel)).getText();
}


 







}

	

	
	


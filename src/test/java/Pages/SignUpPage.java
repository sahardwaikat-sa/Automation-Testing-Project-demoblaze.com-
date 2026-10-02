package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By SignupButton  = By.xpath("//a[@class='nav-link' and text()='Sign up']");
	By LoginButton   = By.xpath("//a[@class='nav-link' and text()='Log in']");
	By CartButton    = By.xpath("//a[@class='nav-link' and text()='Cart']");
	By SignUpLabel   = By.xpath("//h5[@class='modal-title'and text()='Sign up']");
	By UsernameInput = By.xpath("//input[@id='sign-username']");
	By PasswordInput = By.xpath("//input[@id='sign-password']");
	By SignupButton2 = By.xpath("//Button[@onclick='register()'and text()='Sign up']");
	By LoginLabel    = By.xpath("//h5[@id='logInModalLabel']");
	By loginUsername = By.xpath("//input[@id='loginusername']");
	By loginPass     = By .xpath("//input[@id='loginpassword']");
	By loginbutton2  = By.xpath("//button[@onclick='logIn()']");
	
	
	
public SignUpPage(WebDriver driver) {
		
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));}
	
	
	
	
	 public void signupClick() {
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(SignupButton)).click();
	 }

	 public void userSignUp(String username , String pass) {
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(UsernameInput)).sendKeys(username);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordInput)).sendKeys(pass);
		 
	 }
		// Sign Up / Close buttons inside username and pass form ----SignUp----------
	 
		
		public void signUP() {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(SignupButton2)).click();
		}

}




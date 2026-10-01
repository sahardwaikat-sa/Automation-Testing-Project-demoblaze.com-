  package Pages;

	import java.time.Duration;
	

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Reporter;

	public class loginPage1 {

	    WebDriver driver;
	    WebDriverWait wait;

		By SignupButton = By.xpath("//a[@class='nav-link' and text()='Sign up']");
		By LoginButton = By.xpath("//a[@class='nav-link' and text()='Log in']");
		By CartButton = By.xpath("//a[@class='nav-link' and text()='Cart']");
		By SignUpLabel = By.xpath("//h5[@class='modal-title'and text()='Sign up']");
		
		By UsernameInput = By.xpath("//input[@id='sign-username']");
		By PasswordInput = By.xpath("//input[@id='sign-password']");
		By SignupButton2 = By.xpath("//Button[@onclick='register()'and text()='Sign up']");
		
		By LoginLabel = By.xpath("//h5[@id='logInModalLabel']");
		By loginUsername= By.xpath("//input[@id='loginusername']");
		By loginPass  = By .xpath("//input[@id='loginpassword']");
		By loginbutton2= By.xpath("//button[@onclick='logIn()']");
		By WelecomUser = By.xpath("//a[@id='nameofuser']");

	    public loginPage1(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	    public void enterUsername(String username) {
	        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(loginUsername));
	        field.clear();
	        field.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPass));
	        field.clear();
	        field.sendKeys(password);
	    }

	    public void clickLogin() {
	        wait.until(ExpectedConditions.elementToBeClickable(loginbutton2)).click();
	    }

	  

		public String welcomeUser() {
			 return wait.until(ExpectedConditions.visibilityOfElementLocated(WelecomUser)).getText();
			
		}	
		 public void clickLoginmain() {
		        wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
		    }
	  

	 



}

package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkFlow2 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	//------------Locaters---------------
	
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
	By LogOut = By.xpath("//a[@id='logout2']");
	By Laptopcategories = By.xpath("//a[contains(@onclick,'notebook')]");
	By laptop2 = By.xpath("//a[@href='prod.html?idp_=11' and text()='MacBook air']");
	By ASUSItem=By.xpath("//a[@href='prod.html?idp_=14']");
	By NextButton= By.xpath("//button[@id='next2' ]");
	By PreviousButton =By.xpath("//button[@id='prev2' ]");
	By ContactButton = By .xpath("//a[@class='nav-link' and text()='Contact']");
	By ContactEmail=By.xpath("//input[@id='recipient-email']");
	By ContactName =By.xpath("//input[@id='recipient-name']");
	By ContactMessage=By.xpath("//textarea[@id='message-text']");
	By SendMessageButtn= By.xpath("//button[@onclick='send()']");
	By NAME= By.xpath("//div[@class='form-group']/input[@id='name']");
	By Item1  = By .xpath("//a[@class='hrefch' and @href='prod.html?idp_=1']");
	By Item1Price=By.xpath("(//tbody[@id='tbodyid']/tr/td[3])[1]");
	By Item2 = By.xpath("//a[@class ='hrefch' and @href='prod.html?idp_=8']");
	By Item2Price=By.xpath("(//tbody[@id='tbodyid']/tr/td[3])[2]");
    By ProductDescription=By.xpath("//Strong[text()='Product description']");
	By productImag=By.xpath("//img[@src='imgs/sony_vaio_5.jpg']");
	By addCart  = By.xpath("//a[contains(text(),'Add to cart')]");
	By PrductName=By.xpath("//table[@class='table table-bordered table-hover table-striped']//td[text()='Sony vaio i5']");
	By TOTAL = By.xpath("//h2[text()='Total']");
	By TPRICE= By.xpath("//h3[@id='totalp']");
	By PlaceOrderButton=By.xpath("//button[contains(@class,'btn-success')]");
	By CART = By.xpath("//tbody[@id='tbodyid']");
	By CARTROWS = By.xpath("//tbody[@id='tbodyid']/tr");
	

	
	//------------ Constructer-----------
	
 public WorkFlow2(WebDriver driver) {
		
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
}
 
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



public void laptopCategoriesClick() {
	
	wait.until(ExpectedConditions.elementToBeClickable(Laptopcategories)).click();
}

public Boolean laptopIsDisplayed() {
	
	Boolean result = wait.until(ExpectedConditions.visibilityOfElementLocated(laptop2)).isDisplayed();
	return result;

}

public Boolean asusIsDisplayed() {
	
	Boolean result = wait.until(ExpectedConditions.visibilityOfElementLocated(ASUSItem)).isDisplayed();
	return result;}

public Boolean contactNameIsDisplayed() {
	
	Boolean result = wait.until(ExpectedConditions.visibilityOfElementLocated(ContactName)).isDisplayed();
	return result;}


public void nextClick() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(NextButton)).click();
}

public void previousClick() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(PreviousButton)).click();
}


public void contact(String email, String name, String message) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(ContactButton)).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(ContactEmail)).sendKeys(email);
	wait.until(ExpectedConditions.visibilityOfElementLocated(ContactName)).sendKeys(name);
	wait.until(ExpectedConditions.visibilityOfElementLocated(ContactMessage)).sendKeys(message);
	

}
public void sendContactMessage() {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(SendMessageButtn)).click();
	
}
public void contactClick() {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(ContactButton)).click();
		
}

public boolean checkoutIsDisplayed() {
	
return wait.until(ExpectedConditions.visibilityOfElementLocated(NAME)).isDisplayed();
	
	
}

public int emptyCart() {
wait.until(ExpectedConditions.visibilityOfElementLocated(CART));
List<WebElement>cartlist=driver.findElements(CARTROWS);
	int size= cartlist.size();
	return size;
	
}

}

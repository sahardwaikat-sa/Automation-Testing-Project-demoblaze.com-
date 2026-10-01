package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkFlow1Page {

	WebDriver driver;
	WebDriverWait wait;
	
	// Locaters 
	
	By SignupButton = By.xpath("//a[@class='nav-link' and text()='Sign up']");
	By LoginButton = By.xpath("//a[@class='nav-link' and text()='Log in']");
	By CartButton = By.xpath("//a[@class='nav-link' and text()='Cart']");
	By SignUpLabel = By.xpath("//h5[@class='modal-title'and text()='Sign up']");
	
	By UsernameInput = By.xpath("//input[@id='sign-username']");
	By PasswordInput = By.xpath("//input[@id='sign-password']");
	By SignupButton2 = By.xpath("//Button[@onclick='register()'and text()='Sign up']");
	By CloseButton = By.xpath("");
	By LoginLabel = By.xpath("//h5[@id='logInModalLabel']");
	By loginUsername= By.xpath("//input[@id='loginusername']");
	By loginPass  = By .xpath("//input[@id='loginpassword']");
	By loginbutton2= By.xpath("//button[@onclick='logIn()']");
	//------------Items Page--------------------------
	By WelecomUser = By.xpath("//a[@id='nameofuser']");
	By LogOut = By.xpath("//a[@id='logout2']");
    By Item1  = By .xpath("//a[@class='hrefch' and @href='prod.html?idp_=1']");
	By Item1Price=By.xpath("(//tbody[@id='tbodyid']/tr/td[3])[1]");
	By Item2 = By.xpath("//a[@class ='hrefch' and @href='prod.html?idp_=8']");
	By Item2Price=By.xpath("(//tbody[@id='tbodyid']/tr/td[3])[2]");
	By NextButton = By .xpath("//button[@id='next2']");
	By PreviousButton = By.xpath("//button[@id='prev2' and text()='Previous']");
	//-------------Item page---------------------------------
	By ProductDescription=By.xpath("//Strong[text()='Product description']");
	By productName= By.xpath("//h2[@class='name']");
	By ProductPrice=By.xpath("//h3[text()='$790']");
	By productImag=By.xpath("//img[@src='imgs/sony_vaio_5.jpg']");
	By addCart  = By.xpath("//a[contains(text(),'Add to cart')]");
	By HomePageButton= By.xpath("//a[@class='nav-link' and @href='index.html']");
//---------------CART---------------------------
	By PrductName=By.xpath("//table[@class='table table-bordered table-hover table-striped']//td[text()='Sony vaio i5']");
	By TOTAL = By.xpath("//h2[text()='Total']");
	By TPRICE= By.xpath("//h3[@id='totalp']");
	By PlaceOrderButton=By.xpath("//button[contains(@class,'btn-success')]");
	By CART = By.xpath("//tbody[@id='tbodyid']/tr");
	
	//--------------orderplace------------
	By NAME= By.xpath("//div[@class='form-group']/input[@id='name']");
	By Country = By.xpath("//div[@class='form-group']/input[@id='country']");
	By CITY = By.xpath("//div[@class='form-group']/input[@id='city']");
	By Creditcard = By.xpath("//div[@class='form-group']/input[@id='card']");
	By Month = By.xpath("//div[@class='form-group']/input[@id='month']");
	By Year = By.xpath("//div[@class='form-group']/input[@id='year']");
	By Purchase = By.xpath("//button[@onclick='purchaseOrder()']");
	By checkouMessage=By.xpath("//h2[text()='Thank you for your purchase!']");
	By okButton  = By.xpath("//button[@class='confirm btn btn-lg btn-primary' ]");
	By customerinfo =By.xpath("//p[@class='lead text-muted ' and text()='Amount: 360 USD' ]");
	
	
	
	// Constructer
	
	
 public WorkFlow1Page(WebDriver driver) {
		
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	

 

		
	
//-------------------------------------------------------------------------Login------------


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
 //-------------Select Items---------------------------------------------------
  public void selectItem1() {
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Item1)).click();
	  
  }
  
public void selectItem2() {
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Item2)).click();
  }

public int totalPrice() {
	
	String price1= driver.findElement(Item1Price).getText().trim();
	String price2=driver.findElement(Item2Price).getText().trim();
	int price11=Integer.parseInt(price1);
	int price22 =Integer.parseInt(price2);
	return  price11+price22;
}

  
 //--------------Next,Previous------------------------------- 
public void nextClick () {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(NextButton)).click();
	
}
public void previousClick () {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(PreviousButton)).click();
}
	
	
public void addToCard() {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(addCart)).click();
	 
	wait.until(ExpectedConditions.alertIsPresent()).accept();
	
}
	


public void cartClick() {

wait.until(ExpectedConditions.visibilityOfElementLocated(CartButton)).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(CART));

  

}



	
public void placeOrder(String name, String country,String City, String creditcard, String month, String year) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(NAME)).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Country)).sendKeys(country);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CITY)).sendKeys(City);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Creditcard)).sendKeys(creditcard);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Month)).sendKeys(month);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Year)).sendKeys(year);
}


public void placeOrderClick() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceOrderButton)).click();
	
}

public String logintext() {
	
	return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLabel)).getText();
}


 

public String welcomeUser() {
	
	 return wait.until(ExpectedConditions.visibilityOfElementLocated(WelecomUser)).getText();
	
	 
}

public boolean productDescription() {
	
	return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductDescription)).isDisplayed();
	
}


public void backHome() {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageButton)).click();
}

public int cartTotalPrice() {
	 wait.until(ExpectedConditions.visibilityOfElementLocated(TPRICE));
   	 return Integer.parseInt(driver.findElement(TPRICE).getText().trim());
	
	
}


public void purchaseClick() {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(Purchase)).click();
}

public String purcahseMessage() {
	
	return driver.findElement(checkouMessage).getText();
}

}

	

	
	


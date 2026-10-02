package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPlacePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	

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
	
public OrderPlacePage(WebDriver driver) {
		
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
public void placeOrder(String name, String country,String City, String creditcard, String month, String year) {

	wait.until(ExpectedConditions.visibilityOfElementLocated(NAME)).sendKeys(name);
	wait.until(ExpectedConditions.visibilityOfElementLocated(Country)).sendKeys(country);
	wait.until(ExpectedConditions.visibilityOfElementLocated(CITY)).sendKeys(City);
	wait.until(ExpectedConditions.visibilityOfElementLocated(Creditcard)).sendKeys(creditcard);
	wait.until(ExpectedConditions.visibilityOfElementLocated(Month)).sendKeys(month);
	wait.until(ExpectedConditions.visibilityOfElementLocated(Year)).sendKeys(year);
}


public void purchaseClick() {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(Purchase)).click();
}

public String purcahseMessage() {
	
	return driver.findElement(checkouMessage).getText();
}


}

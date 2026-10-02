package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//---------------CART---------------------------
		By PrductName       = By.xpath("//table[@class='table table-bordered table-hover table-striped']//td[text()='Sony vaio i5']");
		By TOTAL            = By.xpath("//h2[text()='Total']");
		By TotalPrice       = By.xpath("//h3[@id='totalp']");
		By PlaceOrderButton = By.xpath("//button[contains(@class,'btn-success')]");
		By CART             = By.xpath("//tbody[@id='tbodyid']");
		By CartButton       = By.xpath("//a[@class='nav-link' and text()='Cart']");
	
	
	

		public  CartPage(WebDriver driver) {
			
			this.driver=driver;
			this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		}
		
		public void cartClick() {

			wait.until(ExpectedConditions.visibilityOfElementLocated(CartButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(CART));	  

			}
		public void placeOrderClick() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceOrderButton)).click();
			
		}
		

public int cartTotalPrice() {
	 wait.until(ExpectedConditions.visibilityOfElementLocated(TotalPrice));
   	 return Integer.parseInt(driver.findElement(TotalPrice).getText().trim());
	
	
}
		
		
		
}

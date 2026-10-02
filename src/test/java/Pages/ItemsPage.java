package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
		By WelecomUser        = By.xpath("//a[@id='nameofuser']");
		By LogOut             = By.xpath("//a[@id='logout2']");
	    By Item1              = By .xpath("//a[@class='hrefch' and @href='prod.html?idp_=1']");
		By Item1Price         = By.xpath("(//tbody[@id='tbodyid']/tr/td[3])[1]");
		By Item2              = By.xpath("//a[@class ='hrefch' and @href='prod.html?idp_=8']");
		By Item2Price         = By.xpath("(//tbody[@id='tbodyid']/tr/td[3])[2]");
		By NextButton         = By .xpath("//button[@id='next2']");
		By PreviousButton     = By.xpath("//button[@id='prev2' and text()='Previous']");
	    By ProductDescription = By.xpath("//Strong[text()='Product description']");
		By productName        = By.xpath("//h2[@class='name']");
		By ProductPrice       = By.xpath("//h3[text()='$790']");
		By productImag        = By.xpath("//img[@src='imgs/sony_vaio_5.jpg']");
		By addCart            = By.xpath("//a[contains(text(),'Add to cart')]");
		By HomePageButton     = By.xpath("//a[@class='nav-link' and @href='index.html']");
		By Laptopcategories   = By.xpath("//a[contains(@onclick,'notebook')]");
		By laptop2            = By.xpath("//a[@href='prod.html?idp_=11' and text()='MacBook air']");
		By ASUSItem           = By.xpath("//a[@href='prod.html?idp_=14']");
		
		
		
		
		
		public  ItemsPage (WebDriver driver) {
			
			this.driver=driver;
			this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		}
		
		
		
		 //-------------Select Items---------------------------------------------------
		  public String selectItem1() {
			  
			 WebElement item1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Item1));
				item1.click();
				wait.until(ExpectedConditions.urlContains("prod.htm"));
				return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
				
				
		  }
		  
		  

			 
		  
		  
		public String selectItem2() {
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(Item2)).click();
			  wait.until(ExpectedConditions.urlContains("prod.htm"));
				return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
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
			
			
		public String addToCard() {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(addCart)).click();
			 
				 Alert alert =wait.until(ExpectedConditions.alertIsPresent());
				String actual= alert.getText();
				alert.accept();
				return actual;
			
		}
		
		

		public boolean productDescription() {
			
			return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductDescription)).isDisplayed();
			
		}


		public void backHome() {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageButton)).click();
		}



		public String welcomeUser() {
			 return wait.until(ExpectedConditions.visibilityOfElementLocated(WelecomUser)).getText();
		
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

}

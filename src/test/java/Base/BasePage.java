package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BasePage {

	protected WebDriver driver;
	protected String Url = "https://www.demoblaze.com/";

	@BeforeClass
	public void setupDriver() {
		driver = new EdgeDriver();
		//driver = new ChromeDriver();
		driver.get(Url);
		Reporter.log("open the Browser");
		driver.manage().window().maximize();
		Reporter.log("maximize the Browser");
		System.out.println("Browser opened");
	}
	
	@BeforeMethod
	public void goHome() {
		driver.get(Url);
		Reporter.log("Reset to home page");}

	//@AfterClass
	//public void tearDown() {
	//	if (driver != null) {
		//	driver.quit();
		//driver = null;
	//}
	//}
}

package Pages;
import org.openqa.selenium.*;

public class Homepage {
	WebDriver driver;
	
	WebElement home = driver.findElement(By.xpath("//li/a[@style='color: orange;']"));
	WebElement homeSelected = driver.findElement(By.xpath("//li/a[@href='/']"));
	WebElement item1 = driver.findElement(By.xpath("//div[@class='features_items']/div[2]//a[@class='btn btn-default add-to-cart']"));
	WebElement item2 = driver.findElement(By.xpath("//div[@class='features_items']/div[3]//a[@class='btn btn-default add-to-cart']"));
	WebElement continueShopping = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
	WebElement loggedIn = driver.findElement(By.xpath("//b[text()]"));
	WebElement uName = driver.findElement(By.xpath("//b"));
	
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public int checkHomePage() {
		if (home.isDisplayed() && homeSelected.isDisplayed())
			return 1;
		else
			return 0;
	}
	
	public void addToCart() {
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", item1);
		item1.click();
		continueShopping.click();
		item2.click();
		continueShopping.click();
	}
	
	public String verifyUName() {
		return uName.getText();
	}
	
}

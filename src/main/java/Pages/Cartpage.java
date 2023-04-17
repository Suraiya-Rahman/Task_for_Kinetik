package Pages;
import org.openqa.selenium.*;

public class Cartpage {
	WebDriver driver;
	
	public WebElement cartPage = driver.findElement(By.xpath("//li/a[@href='/view_cart']"));
	WebElement checkCartPage = driver.findElement(By.xpath("//li[text()='Shopping Cart']"));
	WebElement checkoutButton = driver.findElement(By.xpath("//a[text()='Proceed To Checkout']"));
	WebElement registerButton = driver.findElement(By.xpath("//p/a[@href='/login']"));
	
	public Cartpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public int goToCartAndCheckCartPage() {
		cartPage.click();
		if(checkCartPage.isDisplayed())
			return 1;
		else
			return 0;
	}
	
	public void clickCheckout() {
		checkoutButton.click();
	}
	
	public void clickRegister() {
		registerButton.click();
	}
	
}

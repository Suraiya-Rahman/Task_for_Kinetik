package Pages;
import org.openqa.selenium.*;

public class Paymentpage {
	WebDriver driver;
	
	WebElement nameOnCard = driver.findElement(By.xpath("//input[@data-qa='name-on-card']"));
	WebElement cardNumber = driver.findElement(By.xpath("//input[@data-qa='card-number']"));
	WebElement cvc = driver.findElement(By.xpath("//input[@data-qa='cvc']"));
	WebElement expiryMonth = driver.findElement(By.xpath("//input[@data-qa='expiry-month']"));
	WebElement expiryYear = driver.findElement(By.xpath("//input[@data-qa='expiry-year']"));
	WebElement payButton = driver.findElement(By.xpath("//button[@data-qa='pay-button']"));
	WebElement successMessage = driver.findElement(By.xpath("//section//div[@class='alert-success alert']"));

	public Paymentpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void inputCardDetails() {
		nameOnCard.sendKeys("Test Name");
		cardNumber.sendKeys("1234 5678 9012");
		cvc.sendKeys("123");
		expiryMonth.sendKeys("10");
		expiryYear.sendKeys("25");
	}
	
	public String payAndConfirmSuccess() {
		payButton.click();
		return successMessage.getText();
	}

}

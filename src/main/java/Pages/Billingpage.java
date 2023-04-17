package Pages;
import org.openqa.selenium.*;
//import org.junit.Assert;

public class Billingpage {
	WebDriver driver;
	
	WebElement fullName = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[@class='address_firstname address_lastname']"));
	WebElement company = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[3][@class='address_address1 address_address2']"));
	WebElement address = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[4][@class='address_address1 address_address2']"));
	WebElement cityStateCode = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[@class='address_city address_state_name address_postcode']"));
	WebElement country = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[@class='address_country_name']"));
	WebElement phone = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[@class='address_phone']"));
	WebElement item1 = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
	WebElement item2 = driver.findElement(By.xpath("//a[@href='/product_details/2']"));
	WebElement messageBox = driver.findElement(By.xpath("//textarea[@name='message']"));
	WebElement placeOrderButton = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
	

	public Billingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public String reviewFullName() {
		return fullName.getText();
	}
	
	public String reviewCompany() {
		return company.getText();
	}
	
	public String reviewAddress() {
		return address.getText();
	}
	
	public String reviewCityStateCode() {
		return cityStateCode.getText();
	}
	
	public String reviewCountry() {
		return country.getText();
	}
	
	public String reviewPhone() {
		return phone.getText();
	}
	
	public String reviewItem1() {
		return item1.getText();
	}
	
	public String reviewItem2() {
		return item2.getText();
	}
	
	public void enterMessage() {
		messageBox.sendKeys("This is a test message");
	}
	
	public void placeOrder() {
		placeOrderButton.click();
	}
}

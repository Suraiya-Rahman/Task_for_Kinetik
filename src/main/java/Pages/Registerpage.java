package Pages;
import org.openqa.selenium.*;

public class Registerpage {
	WebDriver driver;
	
	public WebElement signupName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
	WebElement signupEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
	WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
	WebElement title = driver.findElement(By.xpath("//input[@value='Mr']"));
	//WebElement name = driver.findElement(By.xpath("//input[@data-qa='name']"));
	//WebElement email = driver.findElement(By.xpath("//input[@data-qa='email']"));
	WebElement pass = driver.findElement(By.xpath("//input[@data-qa='password']"));
	WebElement selectDayDropdown = driver.findElement(By.xpath("//select[@data-qa='days']"));
	WebElement selectDay = driver.findElement(By.xpath("//select[@data-qa='days']/option[@value='1']"));
	WebElement selectMonthDropdown = driver.findElement(By.xpath("//select[@data-qa='months']"));
	WebElement selectMonth = driver.findElement(By.xpath("//select[@data-qa='months']/option[@value='1']"));
	WebElement selectYearDropdown = driver.findElement(By.xpath("//select[@data-qa='years']"));
	WebElement selectYear = driver.findElement(By.xpath("//select[@data-qa='years']/option[@value='1']"));
	WebElement newsletter = driver.findElement(By.xpath("//input[@name='newsletter']"));
	WebElement specialOffers = driver.findElement(By.xpath("//input[@name='optin']"));
	WebElement firstName = driver.findElement(By.xpath("//input[@name='first_name']"));
	WebElement lastName = driver.findElement(By.xpath("//input[@name='last_name']"));
	WebElement company = driver.findElement(By.xpath("//input[@name='company']"));
	WebElement address1 = driver.findElement(By.xpath("//input[@data-qa='address']"));
	WebElement state = driver.findElement(By.xpath("//input[@data-qa='state']"));
	WebElement city = driver.findElement(By.xpath("//input[@data-qa='city']"));
	WebElement zipcode = driver.findElement(By.xpath("//input[@data-qa='zipcode']"));
	WebElement mobile = driver.findElement(By.xpath("//input[@data-qa='mobile_number']"));
	WebElement createButton = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
	WebElement accountCreateSuccess = driver.findElement(By.xpath("//*[text()='Account Created!']"));
	WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));

	public Registerpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void enterNameAndEmail() {
		signupName.sendKeys("Test");
		signupEmail.sendKeys("test.001@gmail.com");
		signupButton.click();
	}
	
	public void fillForm() {
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", title);
		title.click();
		((JavascriptExecutor) driver).executeScript("arguement[0].scrollIntoView(true);", pass);
		pass.sendKeys("123456");
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", newsletter);
		newsletter.click();
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", specialOffers);
		specialOffers.click();
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", firstName);
		firstName.sendKeys("Test");
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", lastName);
		lastName.sendKeys("User");
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", company);
		company.sendKeys("Test Company");
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", address1);
		address1.sendKeys("18F, Bir Uttam Qazi Nuruzzaman Sarak, West Panthapath");
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", state);
		state.sendKeys("Dhaka");
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", city);
		city.sendKeys("Dhaka");
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", zipcode);
		zipcode.sendKeys("1205");
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", mobile);
		mobile.sendKeys("123456789");
	}
	
	public String createAndVerifySuccess() {
		((JavascriptExecutor) driver).executeScript("arguements[0].scrollIntoView(true);", createButton);
		createButton.click();
		String successMessage = accountCreateSuccess.getText();
		continueButton.click();
		return successMessage;
	}
	
}

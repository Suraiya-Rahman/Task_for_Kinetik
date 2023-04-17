package Main;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Pages.Homepage;
import Pages.Cartpage;
import Pages.Billingpage;
import Pages.Paymentpage;
import Pages.Registerpage;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class runTest {
	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	static Homepage home;
	static Cartpage cart;
	static Billingpage bill;
	static Paymentpage pay;
	static Registerpage register;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\");
		driver = new ChromeDriver();
		home = new Homepage(driver);
		cart = new Cartpage(driver);
		bill = new Billingpage(driver);
		pay = new Paymentpage(driver);
		register = new Registerpage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		startTest();
		verifyHomePage();
		home.addToCart();
		verifyCartPage();
		cart.clickCheckout();
		cart.clickRegister();
		register.enterNameAndEmail();
		register.fillForm();
		verifyAccountCreate();
		cart.cartPage.click();
		cart.clickCheckout();
		verifyBilling();
		bill.enterMessage();
		bill.placeOrder();
		pay.inputCardDetails();
		verifyPaymentSuccess();
		endTest();
	}
	
	public static void startTest() {
		String var10000 = System.getProperty("user.dir");
        String filePath = var10000 + File.separator + "ExtentReports" + File.separator + "AutomationTestReport.html";
        report = new ExtentReports(filePath);
        test = report.startTest("Automation-Task");
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
	}
	
	public static void verifyHomePage() {
		if(home.checkHomePage() == 1)
			test.log(LogStatus.PASS, "Home page is shown");
		else
			test.log(LogStatus.FAIL, "Home page is not shown");
	}
	
	public static void verifyCartPage() {
		if(cart.goToCartAndCheckCartPage() == 1)
			test.log(LogStatus.PASS, "Cart page is shown");
		else
			test.log(LogStatus.FAIL, "Cart page is not shown");
	}
	
	public static void verifyAccountCreate() {
		if(register.createAndVerifySuccess().toString().equalsIgnoreCase("ACCOUNT CREATED!"))
			test.log(LogStatus.PASS, "Account created successfully");
		else
			test.log(LogStatus.FAIL, "Account not created");
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void verifyUserName() {
		if(home.verifyUName().equals(register.signupName))
			test.log(LogStatus.PASS, "Username match");
		else
			test.log(LogStatus.FAIL, "Username does not match");
	}
	
	public static void verifyBilling() {
		if(bill.reviewFullName().toString().equalsIgnoreCase("Test User"))
			test.log(LogStatus.PASS, "Full name matched");
		else
			test.log(LogStatus.FAIL, "Full name mismatch");
		if(bill.reviewCompany().toString().equalsIgnoreCase("Test Company"))
			test.log(LogStatus.PASS, "Company name matched");
		else
			test.log(LogStatus.FAIL, "Company name mismatch");
		if(bill.reviewAddress().toString().equalsIgnoreCase("18F, Bir Uttam Qazi Nuruzzaman Sarak, West Panthapath"))
			test.log(LogStatus.PASS, "Address matched");
		else
			test.log(LogStatus.FAIL, "Address mismatch");
		if(bill.reviewCityStateCode().toString().equalsIgnoreCase("Dhaka Dhaka 1205"))
			test.log(LogStatus.PASS, "Address matched");
		else
			test.log(LogStatus.FAIL, "Address mismatch");
		if(bill.reviewPhone().toString().equalsIgnoreCase("123456789"))
			test.log(LogStatus.PASS, "Phone matched");
		else
			test.log(LogStatus.FAIL, "Phone mismatch");
		if(bill.reviewItem1().toString().equalsIgnoreCase("Blue Top"))
			test.log(LogStatus.PASS, "Item1 matched");
		else
			test.log(LogStatus.FAIL, "Item1 mismatch");
		if(bill.reviewItem2().toString().equalsIgnoreCase("Men Tshirt"))
			test.log(LogStatus.PASS, "Item2 matched");
		else
			test.log(LogStatus.FAIL, "Item2 mismatch");
	}
	
	public static void verifyPaymentSuccess() {
		if(pay.payAndConfirmSuccess().toString().equalsIgnoreCase("Your order has been placed successfully!"))
			test.log(LogStatus.PASS, "Payment successful");
		else
			test.log(LogStatus.FAIL, "Payment unsuccessful");
	}
	
	public static void endTest() {
        report.endTest(test);
        driver.close();
        driver.quit();
        report.flush();
    }
}

package BusinessLogic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseClass.BaseClass;
import Helper.FileReadManager;
import Listeners.Retry;
import Pom.FeedbackPage;
import Pom.LoginPage;
import Pom.TransferFunds;
import Pom.ViewAccountSummaryPage;
import Pom.ViewRecentTransactionsPage;

public class EndToEnd extends BaseClass {

	public WebDriver driver;
	String TransactionDetailsmessage;
	String transactionsRow1;
	String transactionsRow2;
	String transaction;

	@BeforeTest
	public void BrowserLaunch() throws Throwable {

		String userdir = System.getProperty("user.dir");
		String url = FileReadManager.getInstance().getCr().getUrl();

		String getReportPath = FileReadManager.getInstance().getCr().getReportPath();

		System.setProperty("webdriver.chrome.driver", userdir + "\\src\\test\\resource\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		Reporter.log("Browser Opened");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log("Application started");

	}

	@Test(priority = 1, enabled = false, description = "Try login with given incorrect credentials")

	public void failedLoginTest(String username, String password) {

		try {

			// Negative Scenario

			driver.findElement(LoginPage.signIn).click();

			driver.findElement(LoginPage.username).sendKeys("demo_user");
			driver.findElement(LoginPage.password).sendKeys("demo_password");

			driver.findElement(LoginPage.loginbtn).click();
			Reporter.log("Try login with given incorrect credentials");
			Thread.sleep(3000);

			boolean displayed = driver.findElement(LoginPage.failed_login_mesg).isDisplayed();
			Assert.assertFalse(displayed);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@Test(priority = 2, retryAnalyzer = Retry.class, description = "Retry login with correct credentials")

	public void passedLoginTest() {

		try {
			// positive Scenario
			System.out.println("positive Scenario");
			driver.findElement(LoginPage.signIn).click();

			driver.findElement(LoginPage.username).sendKeys("admin");
			driver.findElement(LoginPage.password).sendKeys("admin");

			driver.findElement(LoginPage.loginbtn).click();

		clickonWebelement(null);
			Thread.sleep(3000);

			String welcome_user = driver.findElement(LoginPage.welcome_User).getText();

			System.out.println(welcome_user);
			Reporter.log("Retry login with correct credentials");
			Assert.assertEquals(welcome_user, "Hello Admin User");
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@Test(priority = 3, description = "View Account Summary option")
	public void ViewAccountSummary() throws InterruptedException {

		try {
			Thread.sleep(2000);
			System.out.println("ViewAccountSummary Scenario");
			driver.findElement(ViewAccountSummaryPage.ViewAccountSummary).click();

			Thread.sleep(3000);
			WebElement viewAccountDetailsdropdown = driver
					.findElement(ViewAccountSummaryPage.ViewAccountDetailsDropDown);

			Select s = new Select(viewAccountDetailsdropdown);

			s.selectByValue("800001");
			Thread.sleep(2000);

			driver.findElement(ViewAccountSummaryPage.goBtn).click();
			WebElement findElement = driver.findElement(ViewAccountSummaryPage.AvailableBalance);

			String text = findElement.getText();
			System.out.println(text);
			Reporter.log("View Account Summary option");
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 4, description = "Transfer Funds", invocationCount = 2)

	public void transferFunds()

	{

		try {
			Thread.sleep(2000);
			System.out.println("Transfer Funds Scenario");
			driver.findElement(TransferFunds.tranferfund).click();

			Thread.sleep(2000);

			Select fromAccount = new Select(driver.findElement(TransferFunds.fromAccount));
			Select toAccount = new Select(driver.findElement(TransferFunds.toAccount));

			fromAccount.selectByValue("800000");
			toAccount.selectByValue("800001");

			driver.findElement(TransferFunds.transferAmount).sendKeys("9876");

			driver.findElement(TransferFunds.transfermoneybtn).click();

			Thread.sleep(3000);

			TransactionDetailsmessage = driver.findElement(TransferFunds.transactionDetailsmessage).getText();

			System.out.println(TransactionDetailsmessage);

			Reporter.log("Transfer Funds Scenario");
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@Test(priority = 5, description = "ViewRecentTransactions")

	public void viewRecentTransactions()

	{

		try {

			Thread.sleep(3000);
			driver.findElement(ViewRecentTransactionsPage.view_Recent_Transactions_link).click();
			transactionsRow1 = driver.findElement(ViewRecentTransactionsPage.first_row).getText();

			System.out.println(transactionsRow1);

			transactionsRow2 = driver.findElement(ViewRecentTransactionsPage.second_row).getText();
			System.out.println(transactionsRow2);

			Thread.sleep(3000);
			driver.findElement(ViewRecentTransactionsPage.contact_Us).click();
			Thread.sleep(3000);
			driver.findElement(ViewRecentTransactionsPage.online_form).click();

			// driver.findElement(ViewRecentTransactionsPage.first_row).click();
			Reporter.log("ViewRecentTransactions");
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@Test(priority = 6, description = "FeedbackPage")

	public void feedbackPage()

	{

		try {

			Reporter.log("FeedbackPage");
			Thread.sleep(3000);
			driver.findElement(FeedbackPage.you_EmailAddress).sendKeys("preavenn@gmail.com");

			driver.findElement(FeedbackPage.Subject).sendKeys("helloe");

			driver.findElement(FeedbackPage.question_Comment).sendKeys("test data");

			driver.findElement(FeedbackPage.Submit).click();
			Thread.sleep(3000);
			driver.findElement(FeedbackPage.signOff).click();

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@AfterTest
	public void quitBrowser() throws Exception {

		// driver.quit();

		Reporter.log("Application closed");
	}

}

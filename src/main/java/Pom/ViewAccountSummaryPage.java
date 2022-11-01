package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewAccountSummaryPage {

	WebDriver driver;

	public static By ViewAccountSummary = By.linkText("View Account Summary");
	public static By ViewAccountDetailsDropDown = By.id("listAccounts");
	public static By goBtn = By.id("btnGetAccount");
	public static By AvailableBalance = By.xpath("//td[normalize-space(text()) = 'Available balance']/following-sibling::td");

	public ViewAccountSummaryPage(WebDriver driver) {
		this.driver = driver;

	}
}

package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewRecentTransactionsPage {

	WebDriver driver;
	public static By view_Recent_Transactions_link = By.xpath("//a[text()='View Recent Transactions']");

	public static By first_row = By.xpath("//td[text()='Transaction ID']//following::tr[1]");
	public static By second_row = By.xpath("//td[text()='Transaction ID']//following::tr[2]");

	public static By contact_Us = By.xpath("//a[text()='Contact Us']");

	public static By online_form = By.xpath("//a[text()='online form']");

	public ViewRecentTransactionsPage(WebDriver driver) {
		this.driver = driver;

	}
}

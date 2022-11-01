package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferFunds {

	WebDriver driver;

	public static By tranferfund = By.xpath("//a[@id=\"MenuHyperLink3\"]");
	public static By toAccount = By.id("toAccount");
	public static By fromAccount = By.id("fromAccount");
	public static By transferAmount = By.id("transferAmount");
	public static By transactionDetailsmessage = By.xpath("//span[@id=\"_ctl0__ctl0_Content_Main_postResp\"]");
	public static By transfermoneybtn = By.id("transfer");

	public TransferFunds(WebDriver driver) {
		this.driver = driver;

	}
}

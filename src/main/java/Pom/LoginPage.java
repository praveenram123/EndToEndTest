package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	public static By signIn = By.xpath("//font[text()='Sign In']");
	public static By username = By.id("uid");
	public static By password = By.id("passw");
	public static By loginbtn = By.xpath("//input[@name=\"btnSubmit\"]");
	public static By welcome_User = By.xpath("//h1[normalize-space(text()) = 'Hello Admin User']");
	public static By failed_login_mesg = By.xpath("//span[@id=\"_ctl0__ctl0_Content_Main_message\"]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}
}

package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeedbackPage {

	WebDriver driver;

	public static By signOff = By.xpath("//font[text()='Sign Off']//parent::a");

	public static By Subject = By.xpath("//input[@name='subject']");

	public static By you_EmailAddress = By.xpath("//input[@name='email_addr']");

	public static By question_Comment = By.xpath("//textarea[@name='comments']");

	public static By Submit = By.xpath("//input[@type=\"submit\"]");
	
	
	//input[@value=" Submit "]
	public FeedbackPage(WebDriver driver) {
		this.driver = driver;

	}
}

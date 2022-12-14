package pom;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

public class LoginPage {

	String className = this.getClass().getSimpleName();
	@FindBy(xpath = "//input[@id='identifierId']")
	private WebElement userId;

	@FindBy(xpath = "//span[text()='Next']")
	private WebElement nextButton;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passward;

	@FindBy(xpath = "//img[@class='gb_Ia gbii']")
	private WebElement profile;

	@FindBy(xpath = "//div[text()='Sign out']")
	private WebElement signOut;

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// this.driver = driver;
	}

	public void sendUserName(String userID) {
		userId.sendKeys(userID);
	}

	public void sendPassward(String pass) throws InterruptedException {
		Thread.sleep(3000);
		/*
		 * wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.elementToBeClickable(passward));
		 */
		passward.sendKeys(pass);
	}

	public void clickOnNext() {
		nextButton.click();
	}

	public void clickOnProfile() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(profile)).click();

	}

	public void clickOnsignOut() throws InterruptedException {
		//Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signOut)).click();
		
	}

	public void loginToGmail(String userName, String passWord) throws InterruptedException {
		sendUserName(userName);
		//Log.info(userName + " filled in username field", className);
		nextButton.click();
		sendPassward(passWord);
		//Log.info(passWord + " filled in password field", className);
		nextButton.click();
		//Log.info(" Made click on next button", className);
		profile.click();
	}
}




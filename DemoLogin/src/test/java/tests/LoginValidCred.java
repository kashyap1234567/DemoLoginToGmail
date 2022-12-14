package tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Browser;

import utils.Utility;

public class LoginValidCred extends Browser {

	public	pom.LoginPage loginpg;

	@BeforeClass
	public void createPOMObject() {

		loginpg = new pom.LoginPage(driver);

	}


	@Test
	public void loginWithValidCredentails() throws EncryptedDocumentException, IOException, InterruptedException {
		//loginpg.loginToGmail(properties.getProperty("user"), properties.getProperty("password"));
		System.out.println("login To Application");

		String userName = Utility.getDataFromExcel("Sheet1",1,0);
		String Passward = Utility.getDataFromExcel("Sheet1",1,1);
		loginpg.loginToGmail(userName, Passward);
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//div[text()='Sign out']")).click();
		}
		catch(NoSuchElementException e) {
			System.out.println("Handled NoSuchElementException");
		}

	}

	@AfterClass
	public void tearDown() { driver.quit(); }

}



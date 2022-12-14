package base;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver driver;
	public static Properties properties;

	@BeforeTest
	public void launchBrowser() {

		driver = WebDriverManager.chromedriver().create();

		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	public Browser() {
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("./config.properties/");
			properties.load(ip);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

package appiumtests.appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class SampleTest {

	static AppiumDriver<MobileElement> driver;
	static AppiumDriverLocalService appiumService;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		appiumService = AppiumDriverLocalService.buildDefaultService();
		System.out.println("Start appium service");
		appiumService.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "ASUS ZENFONE LASER 2");
		cap.setCapability("udid", "G1AZGU021327BBK");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "5.0.2");
		cap.setCapability("appPackage", "com.asus.calculator");
		cap.setCapability("appActivity", "com.asus.calculator.Calculator");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("App started!");
	}

	@Test
	public static void Calculate() throws Exception {
		try {
			MobileElement three = driver.findElement(By.id("com.asus.calculator:id/digit3"));
			three.click();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			MobileElement plus = driver.findElement(By.id("com.asus.calculator:id/plus"));
			plus.click();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			MobileElement three = driver.findElement(By.id("com.asus.calculator:id/digit3"));
			three.click();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			MobileElement equals = driver.findElement(By.id("com.asus.calculator:id/equal"));
			equals.click();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			MobileElement results = driver.findElement(By.id("android.widget.LinearLayout"));
			String res = results.getText();
			System.out.println("\n Result is : " + res);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@AfterTest
	public void End() {
		System.out.println("Stop driver");
		driver.quit();
		System.out.println("Stop appium service");
		appiumService.stop();
	}

}

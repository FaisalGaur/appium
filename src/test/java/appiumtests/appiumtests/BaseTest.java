package appiumtests.appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {

	static AppiumDriver<MobileElement> driver;
	static AppiumDriverLocalService appiumService;

	@BeforeSuite
	public void setUp() throws MalformedURLException {
		appiumService = AppiumDriverLocalService.buildDefaultService();
		System.out.println("Start appium service");
		appiumService.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("noReset", "true");
		cap.setCapability("deviceName", "Pixel 3a Emulator");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("appPackage", "com.deskera.desk");
		cap.setCapability("appActivity", "com.deskera.desk.onboarding.dashboard.LandingActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("App started!");
	}

	@AfterSuite
	public void End() {
		System.out.println("Stop driver");
		driver.quit();
		System.out.println("Stop appium service");
		appiumService.stop();
	}

}

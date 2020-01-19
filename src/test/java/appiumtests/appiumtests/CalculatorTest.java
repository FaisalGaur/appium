package appiumtests.appiumtests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class CalculatorTest {

	static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			openCalculator();
		} catch (Exception exp) {

		}

	}

	public static void openCalculator() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("noReset", "false");

		cap.setCapability("deviceName", "ASUS ZENFONE LASER 2");
		cap.setCapability("udid", "G1AZGU021327BBK");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "5.0.2");
		cap.setCapability("appPackage", "com.asus.calculator");
		cap.setCapability("appActivity", "com.asus.calculator.Calculator");

		// Build the Appium service
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

		Object service = AppiumDriverLocalService.buildService(builder);
		((AppiumDriverLocalService) service).start();

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("App started!");

		MobileElement three = driver.findElement(By.id("com.asus.calculator:id/digit3"));
		MobileElement plus = driver.findElement(By.id("com.asus.calculator:id/plus"));
		MobileElement equals = driver.findElement(By.id("com.asus.calculator:id/equal"));
		MobileElement results = driver.findElement(By.id("android.widget.LinearLayout"));

		three.click();
		plus.click();
		three.click();
		equals.click();

		String res = results.getText();
		System.out.println("\n Result is : " + res);
		((AppiumDriverLocalService) service).stop();

	}

}

package journeyTest.MobileTestAutomation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	static GetEmailFromPostPage page;

	@BeforeClass
	public static void AndroidSetup() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C://Users//LENOVO//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("app",
				"C://Users//LENOVO//eclipse mobile workspace//MobileTestAutomation//src//test//java//Resources//Journey-Test-App.apk");
		options.setDeviceName("Test Emulator");
		options.setCapability("adbExecTimeout", 10000);
		options.setCapability("uiautomator2ServerLaunchTimeout", 10000);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		page = PageFactory.initElements(driver, GetEmailFromPostPage.class);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
}

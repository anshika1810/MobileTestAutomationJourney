package journeyTest.MobileTestAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class GetEmailFromPost extends BaseClass {

	@Test
	public void getEmailFromPost() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement searchButton = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Search")));
		searchButton.click();

		WebElement searchTextBox = wait.until(ExpectedConditions.elementToBeClickable(page.getSearchTextBox()));
		searchTextBox.sendKeys("eum et est");

		WebElement postClick = wait.until(ExpectedConditions.elementToBeClickable(page.getPostClick()));
		postClick.click();

		List<WebElement> list = page.getEmailList();
		Thread.sleep(5000);
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0

					));
		} while (canScrollMore);

		list = page.getEmailList();
		System.out.println("LIST OF EMAILS FROM THE POST TITLE :-");
		for (WebElement e : list) {
			System.out.println(e.getText());
		}
	}

	@AfterClass
	public void tearDown() {

		service.stop();
		driver.quit();

	}
}

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_login_3 {

	private WebDriver driver;

	@Before
	public void openBrowser() {
		// baseUrl = System.getProperty();
		driver = new FirefoxDriver();
		driver.navigate().to("http://apsrd7365:8080/OptumPMP/#/");
		driver.manage().window().maximize();

	}

	@After
	public void CloseBrowser() throws IOException {

		driver.close();
	}

	@Test
	public void TC_login_3() throws IOException {

		driver.findElement(By.xpath("//*[@id='username_input']")).sendKeys("");
		driver.findElement(By.xpath("//*[@id='password_input']")).sendKeys("");
		

		driver.findElement(By.xpath("//*[@id='loginButton']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals("Patient", driver.getTitle());
		String s = driver.findElement(By.xpath(".//*[@id='Error-description']/span")).getText();
		System.out.println(s);
		assertEquals("Fields can not be empty", s);
		
	}

	
	private class ScreenshotHelper {

		public void saveScreenshot(String screenshotFileName) throws IOException {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(screenshotFileName));
		}
	}
}

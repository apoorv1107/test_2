package registerVisit;
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

public class TC_Patient_registerVisit_1 {

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
	public void TC_Patient_SearchProvider_1() throws IOException {

		driver.findElement(By.xpath("//*[@id='username_input']")).sendKeys("PAT001");
		driver.findElement(By.xpath("//*[@id='password_input']")).sendKeys("Optum123@");
		WebElement roleSelectElement = driver.findElement(By.xpath(".//*[@id='dropDownId1']"));
		Select roleDropdown = new Select(roleSelectElement);
		roleDropdown.selectByVisibleText("Patient");
		driver.findElement(By.xpath("//*[@id='loginButton']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("html/body/div/div[1]/div[1]/ul/li[3]/a/span[1]")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//html/body/div/div[1]/div[4]/ul/li[2]/a
		driver.findElement(By.xpath("html/body/div/div[1]/div[2]/ul/li[2]/a")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement select = driver.findElement(By.xpath(".//*[@id='select']"));
		Select dropdown = new Select(select);
		dropdown.selectByVisibleText("apollo Hospital");
		
		//assertEquals("Search Provider", driver.getTitle());
		driver.findElement(By.xpath(".//*[@id='calendar_cal']")).sendKeys("10-22-2016");
		driver.findElement(By.xpath("html/body/div/div[1]/div[6]/table/tbody/tr[3]/td[2]/input")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String success = driver.findElement(By.xpath(".//*[@id='success-message-description']/span")).getText();
		
		assertEquals(success.contains("registered successfully with visit id : "), true);
		
	}

	
	
}

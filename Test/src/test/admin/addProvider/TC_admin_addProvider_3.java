package admin.addProvider;
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

public class TC_admin_addProvider_3 {

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
	public void TC_admin_addProvider_1() throws IOException {

		driver.findElement(By.xpath("//*[@id='username_input']")).sendKeys("ADM001");
		driver.findElement(By.xpath("//*[@id='password_input']")).sendKeys("Optum123@");
		WebElement roleSelectElement = driver.findElement(By.xpath(".//*[@id='dropDownId1']"));
		Select roleDropdown = new Select(roleSelectElement);
		roleDropdown.selectByVisibleText("Admin");
		driver.findElement(By.xpath("//*[@id='loginButton']")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("html/body/div/div[1]/div[1]/ul/li[4]/a/span[1]")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("html/body/div/div[1]/div[2]/ul/li[2]/a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.findElement(By.xpath(".//*[@id='addProviderButton']")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String error = driver.findElement(By.xpath(".//*[@id='Error']/div/div")).getText();
		//System.out.println(error);
		assertEquals(error.contains("Fields can not be empty"),true);
		//assertEquals("Search Provider", driver.getTitle());
	}

	
	
}

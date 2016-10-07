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

public class TC_admin_addProvider_2 {

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
	public void TC_admin_addProvider_2() throws IOException {

		driver.findElement(By.xpath("//*[@id='username_input']")).sendKeys("ADM001");
		driver.findElement(By.xpath("//*[@id='password_input']")).sendKeys("Optum123@");
		WebElement roleSelectElement = driver.findElement(By.xpath(".//*[@id='dropDownId1']"));
		Select roleDropdown = new Select(roleSelectElement);
		roleDropdown.selectByVisibleText("Admin");
		driver.findElement(By.xpath("//*[@id='loginButton']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("html/body/div/div[1]/div[1]/ul/li[4]/a/span[1]")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("html/body/div/div[1]/div[2]/ul/li[2]/a")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='providerId_input']")).sendKeys("PRV199");
		driver.findElement(By.xpath("//*[@id='firstName_input']")).sendKeys("abc");
		driver.findElement(By.xpath("//*[@id='lastName_input']")).sendKeys("xyz");
		driver.findElement(By.xpath("//*[@id='location_input']")).sendKeys("bangalore");
		driver.findElement(By.xpath("//*[@id='email_input']")).sendKeys("abc@gmail.in");
		WebElement SelectElement = driver.findElement(By.xpath(".//*[@id='dropDownId1']"));
		Select Dropdown = new Select(SelectElement);
		Dropdown.selectByVisibleText("Hospital");
		
		driver.findElement(By.xpath("//*[@id='ssn_input']")).sendKeys("123456789");
		WebElement SelectExperience = driver.findElement(By.xpath(".//*[@id='dropDownId2']"));
		Select Drop = new Select(SelectExperience);
		Drop.selectByVisibleText("YES");
		
		driver.findElement(By.xpath(".//*[@id='addProviderButton']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String error = driver.findElement(By.xpath(".//*[@id='Error-description']/span")).getText();
		System.out.println(error);
		assertEquals("Provider addition failed", error);
		//assertEquals("Search Provider", driver.getTitle());
	}

	
	
}

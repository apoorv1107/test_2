package admin.addPatient;
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

public class TC_admin_addPatient_3 {

	private WebDriver driver;

	@Before
	public void openBrowser() {
		// baseUrl = System.getProperty();
		driver = new FirefoxDriver();
		driver.navigate().to("http://apsrd7365:8080/OptumPMP1/#/");
		driver.manage().window().maximize();

	}

	@After
	public void CloseBrowser() throws IOException {

		driver.close();
	}

	@Test
	public void TC_admin_addPatient_3() throws IOException {

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
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("html/body/div/div[1]/div[2]/ul/li[4]/a")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id='patientId_input']")).sendKeys("PAT981");
		driver.findElement(By.xpath("//*[@id='firstname_input']")).sendKeys("apo");
		driver.findElement(By.xpath("//*[@id='lastname_input']")).sendKeys("tri");
		driver.findElement(By.xpath("//*[@id='email_input']")).sendKeys("apv@t.in");
		driver.findElement(By.xpath("//*[@id='ssn_input']")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id='age_input']")).sendKeys("22");
		//driver.findElement(By.xpath(".//*[@id='dobID_cal']")).sendKeys("11-01-1999");
		driver.findElement(By.xpath(".//*[@id='add_patient']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String success = driver.findElement(By.xpath(".//*[@id='Error-description']/span")).getText();
		System.out.println(success);
		assertEquals("patient addition failed", success);
		
	}

	
	
}

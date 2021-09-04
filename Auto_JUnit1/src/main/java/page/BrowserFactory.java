package page;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://techfios.com/test/101/index.php");
	}

	@Test
	public void usershouldbeabletocheckvalidation() {

		//Test 1: Validate when the toggle all check box is CHECKED, all check boxes for list items are also CHECKED ON.
		driver.findElement(By.xpath("//input[@type='checkbox' and @name='allbox']")).click();
		
		//Test 2: Validate that a single list item could be removed using the remove button when a single checkbox is selected.
		driver.findElement(By.xpath("//input[@type='checkbox' and @name='todo[1]']")).click();
		driver.findElement(By.xpath("//input[@type='submit' and @value='Remove']")).click();
		
		//Test 3: Validate that all list item could be removed using the remove button and when "Toggle All" functionality is on.
		driver.findElement(By.xpath("//input[@type='checkbox' and @ onclick='checkAll();']")).click();
		driver.findElement(By.xpath("//input[@type='submit' and @value='Remove']")).click();
	}
	
		@After
		public void tearDown() {
		driver.close();
		driver.quit();
		}
		
		
}

package chromedriverdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumScript {
	
	@Test
	public void firstProgram() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Mukesh Otwani");
		Assert.assertFalse(driver.findElement(By.xpath("//input[@title='search']")).getText().equals("Mukesh Otwani"));
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		driver.quit();
		
				

	}

}

package jenkins;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmokeTest {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
	}
	
	@Test
	public void RightPassword() {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
		System.out.println("valid Password");
		driver.quit();
	}
	@Test
	public void WrongPassword() {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASD");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[@id='spanMessage']"));
		Assert.assertEquals(ele.getText(),"Invalid credentials");
		System.out.println("Invalid Password");
	}
	@Test
	public void verifyBlank() {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[@id='spanMessage']"));
		AssertJUnit.assertEquals(ele.getText(),"Username cannot be empty");
		System.out.println("Enter username");
	}
	
	}



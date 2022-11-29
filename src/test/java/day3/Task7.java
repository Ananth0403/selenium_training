package day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task7 {
	
	@Test
	public void dayThreeProgram() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ineuron-courses.vercel.app/login");
		
		
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("ineuron@ineuron.ai");
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("ineuron");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Manage']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//span[normalize-space()='Manage Categories']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		List<String>arr = new ArrayList<String>(driver.getWindowHandles());
		
		String page = arr.get(0);
		String page1 = arr.get(1);
		
		driver.switchTo().window(page1);
		driver.findElement(By.xpath("//button[normalize-space()='Add New Category']")).click();
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert ele=wait.until(ExpectedConditions.alertIsPresent());
		ele.dismiss();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("manage"));
		
		
		
		
		

	}

}

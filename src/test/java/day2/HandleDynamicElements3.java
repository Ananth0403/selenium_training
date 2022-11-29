package day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDynamicElements3 {
	
	@Test()
	public void chromeDemo3() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("alert"));
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		try {
			Alert element=wait.until(ExpectedConditions.alertIsPresent());
			element.accept();
			
		}catch(Exception e) {
			e.getMessage();
		}

	}

}

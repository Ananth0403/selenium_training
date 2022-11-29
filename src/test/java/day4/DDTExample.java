package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDTExample {
	
	@Test(dataProvider="testdata")
	public void myTest(String username,String password) {
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password1']")).sendKeys(password);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).getText().contains("Sign out")) ;
	}
	
	@DataProvider(name="testdata")
	public Object[][] testDataGeneration(){
		Object[][] arr = new Object[4][2];
		arr[0][0]=" sample9@gmail.com";
		arr[0][1]="Mukesh1234";
		arr[1][0]="samplemukesh@gmail.com";
		arr[1][1]="Mukesh1234";
		arr[2][0]="samplemukesh1@gmail.com";
		arr[2][1]="Mukesh1234";
		arr[3][0]="samplemukesh2@gmail.com";
		arr[3][1]="Mukesh1234";
		
		return arr;
	}

}

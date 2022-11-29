package day5;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoItDemo {

		public static void main(String[] args) throws InterruptedException, IOException {
			
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://the-internet.herokuapp.com/upload");
			
			Actions act = new Actions(driver);
			
			act.moveToElement(driver.findElement(By.id("file-upload"))).click().perform();
			
			Thread.sleep(3000);
			
			Runtime.getRuntime().exec("C:\\Users\\anam\\Desktop\\auto.exe");
			
			driver.findElement(By.id("file-submit")).click();
			
		}
}

package day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLogin {
	
	public static void main(String[] args) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://137.184.76.209/orangehrm-4.9");
	    driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
	    driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
	    driver.findElement(By.xpath("//input[@class='button']")).click();
	    driver.findElement(By.xpath("//a[contains(@class,'firstLevelMenu')]")).click();
	    driver.findElement(By.xpath("//input[contains(@name,'btnAdd')]")).click();
	    WebElement user = driver.findElement(By.name("User Role"));
	    Select select = new Select(user);
	    List<WebElement> allValues = select.getOptions();
	    allValues.get(1).findElement(By.xpath("//option[@value='1']")).click();
	   /* for(int i=0;i<select)
	    select.selectByVisibleText("Admin");
	    /*driver.findElement(By.xpath("//label[@for='systemUser_userName']")).sendKeys("James");
	    WebElement status = driver.findElement(By.xpath("//select[@id='systemUser_status']"));
	    Select drpstatus = new Select(status);
	    select.selectByVisibleText("Enabled");
	    driver.findElement(By.id("systemUser_password")).sendKeys("ABcd!35");
	    driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("ABcd!35");
	    driver.findElement(By.xpath("//input[contains(@name,'btnSave')]")).click();
	    WebElement welcome = driver.findElement(By.id("welcome"));
	    Select drpwelcome = new Select(welcome);
	    drpwelcome.selectByVisibleText("Logout");*/
	}
    
 
}

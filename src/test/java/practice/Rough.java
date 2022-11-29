package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Rough {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//a[@class = 'subLink']")).click();
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Ananth");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("anishananth2@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ananth");
		
		Actions act =  new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[text()='selenium']"))).click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//select[@name = 'state']")));
        
		
		
		WebElement wb = driver.findElement(By.xpath("//select[@name = 'state']"));
		Select select = new Select(wb);
		List<WebElement>list = select.getOptions();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().contains("Kerala")) {
				list.get(i).click();
				break;
			}
		}
		act.moveToElement(driver.findElement(By.xpath("//input[@value='Male']"))).doubleClick();
		
		
		
		

	}

}

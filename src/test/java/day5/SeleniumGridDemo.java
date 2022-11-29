package day5;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGridDemo {
	
	WebDriver driver ;
	@BeforeMethod
	public void setup() {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("browserVersion", "latest");
		capabilities.setCapability("os", "windows");
		capabilities.setCapability("osVersion", "8");
		
		URL url = null;
		
		try {
			url = new URL("https://ananth_nBKiUV:dMhncmepsmwLpKZqCX1h@hub-cloud.browserstack.com/wd/hub");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		driver = new RemoteWebDriver(url,capabilities);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void testURL() {
		driver.get("https://www.browserstack.com/automate/capabilities");
	}

}

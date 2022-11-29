package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginClass {
	WebDriver driver;
	
	@Given("User open the application")
	public void user_open_the_application() {
	    driver = new ChromeDriver();
	    driver.get("https://ineuron-courses.vercel.app/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@When("User enter username as {string}")
	public void user_enter_username_as(String string) {
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(string);
	    
	}

	@When("user enter password as {string}")
	public void user_enter_password_as(String string) {
		driver.findElement(By.xpath("//input[@name='password1']")).sendKeys(string);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("user should be able to login")
	public void user_should_be_able_to_login() {
	    Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Sign out')]")).isDisplayed());
	}
	
	@Then("user should not be able to login")
	public void user_should_not_be_able_to_login() {
		 Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='errorMessage']")).isDisplayed());
	}

	@When("user clicks on signout button")
	public void user_clicks_on_signout_button() {
		driver.findElement(By.xpath("//*[contains(text(),'Sign out')]")).click();
	}

	@Then("user should be able to logout")
	public void user_should_be_able_to_logout() {
		Assert.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
	}

	@Then("close the application")
	public void close_the_application() {
	    driver.quit();
	}


}


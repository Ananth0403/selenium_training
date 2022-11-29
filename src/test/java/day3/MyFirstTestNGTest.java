package day3;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestNGTest {
	
	@Test
	public void login() {
		System.out.println("login done");
	}
	
	@Test
	public void createAccount() {
		System.out.println("Account created");
	}
	
	@Test
	public void deleteAccount() {
		Assert.assertEquals(false,true);
		System.out.println("Account deleted");
	}
	
	@Test(dependsOnMethods="deleteAccount")
	public void logOut() {
		System.out.println("logout Done");
	}
	
}

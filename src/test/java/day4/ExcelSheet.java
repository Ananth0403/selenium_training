package day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelSheet {

	ChromeDriver driver;
	@BeforeMethod
	public void setup() {
		driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.get("https://ineuron-courses.vercel.app/login");

	}
	@AfterMethod
	public void Clearup() {
		driver.quit();
	}

	@Test(dataProvider="TestData")
	public void Test(String s1,String s2) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("email1")).sendKeys(s1);
		driver.findElement(By.id("password1")).sendKeys(s2);
		driver.findElement(By.className("submit-btn")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Sign out']")).isDisplayed(), true);
	}
	@DataProvider(name="TestData")
	public Object[][]testDataGeneration()
	{
		Object[][]arr=null;
		try {
			XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(new File("./testdata/SapientTestData.xlsx")));
			int rows=wb.getSheet("loginData").getPhysicalNumberOfRows();
			int column=wb.getSheet("loginData").getRow(0).getPhysicalNumberOfCells();
			arr=new Object[rows][column];
			for(int i=0;i<rows;i++) {
				for(int j=0;j<column;j++) {
					arr[i][j]=wb.getSheet("LoginData").getRow(i).getCell(j).getStringCellValue();
				}
			}
			System.out.println(arr);
			wb.close();
		}catch(FileNotFoundException e) {
			System.out.println("Please check file path"+e.getMessage());
		}catch(IOException e) {
			System.out.println("Something went wrong IO"+e.getMessage());
		}
		return arr;

	}
}

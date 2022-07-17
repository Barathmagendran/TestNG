package org.flikart;



import java.io.File;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class FlikartTaskNew {
	static WebDriver driver;
	static long bTime;
	static String text;
	static String text1;
	@DataProvider(name="mobile")
	public 	 Object[][] moblieName() {
	return new Object[][] {{"redmi mobiles"}};
	}
	
    @Parameters("URL")
	@BeforeClass(groups="default")
public static void browserLaunch(String url) {
		System.out.println("browser lanuched successfully");
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
}
	@AfterClass(groups="default")
	public void browserquit() {
		//driver.quit();
		System.out.println("browser quitted");
	}
	@BeforeMethod(groups="default")
	public void beforeMethod() {
		 bTime = System.currentTimeMillis();
		 System.out.println(bTime);
	}
	@AfterMethod(groups="default")
	public void afterMethod() {
		 long aTime = System.currentTimeMillis();
		 System.out.println(aTime);
		 System.out.println("total time:"  +(aTime-bTime));
	}
	@Test(priority=1,groups="barath")
	public void logIn() {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	}
@Test(priority=2,groups="barath",dataProvider="mobile")
		public void method2(String name) throws Throwable {
			WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
			search.sendKeys(name,Keys.ENTER);
		
	}
@Test(priority=3,groups="barath")
public void method3() throws Throwable {
	Thread.sleep(1000);
	WebElement mobile=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
	text=mobile.getText();
	System.out.println("mobile name" +text);
}
@Test(priority=4,groups="barath")
public void method4() {
	WebElement move = driver.findElement(By.xpath("//input[@type='text']"));
	Actions acc=new Actions(driver);
	acc.moveToElement(move).perform();
	System.out.println("move to element");
}
@Test(priority=5,groups="barath")
public void multiple() throws Throwable {
		Thread.sleep(1000);
		WebElement mobile1=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		mobile1.click();
		Thread.sleep(1000);
		WebElement mobile2=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
		mobile2.click();
		Thread.sleep(1000);
		WebElement mobile3=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
		mobile3.click();
}
@Test(priority=6,groups="barath")
public void method6() throws Throwable {
	Set<String>child=driver.getWindowHandles();
	List<String>parent=new ArrayList<String>(child);
	for(String x:parent) {
		driver.switchTo().window(x);
		driver.switchTo().window(parent.get(3));
	}
		WebElement get = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		 text1 = get.getText();
		System.out.println(text1);
	
	File f=new File("C:\\Users\\SRITHAR\\eclipse-workspace\\ParticeTestNG\\src\\test\\resources\\TestNG.xlsx");
    HSSFWorkbook f1=new HSSFWorkbook();
	Sheet s = f1.createSheet();
	Row r = s.createRow(0);
	Cell c = r.createCell(1);
	c.setCellValue(text1);
	FileOutputStream f3=new FileOutputStream (f);
	f1.write(f3);

}
@Test(priority=7,enabled=false)
public void screenShot() throws Throwable {
TakesScreenshot tk=(TakesScreenshot)driver;
File src=tk.getScreenshotAs(OutputType.FILE);
File des=new File("C:\\Users\\SRITHAR\\eclipse-workspace\\ParticeTestNG\\src\\test\\resources\\barath");
FileUtils.copyFile(src,des);
}
}

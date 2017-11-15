package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDemo {

	static WebDriver driver;
	public static void main(String[] args) {
		
		TestDemo testdemo=new TestDemo();
		String baseURL="http://demo.guru99.com/selenium/newtours/";
		
		driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.get(baseURL);
		testdemo.testTitle();
		
		System.out.println("Successfully Done");
		
		testdemo.registerPage();
		System.out.println("Registration done succeefully");
		
		
	}
	
	public void testTitle()
	{
		String expectedTitle="Welcome: Mercury Tours";
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
	}
	
	public void registerPage()
	{
		driver.findElement(By.xpath(".//*[contains(text(),'SIGN-ON')]")).click();
		driver.findElement(By.xpath(".//a[contains(text(),'registration ')]")).click();
		
		System.out.println(driver.getTitle());
		driver.findElement(By.name("firstName")).sendKeys("Hemanth");
		driver.findElement(By.name("lastName")).sendKeys("S");
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		driver.findElement(By.name("userName")).sendKeys("test@gmail.com");
		driver.findElement(By.name("city")).sendKeys("Mysuru");
		driver.findElement(By.name("state")).sendKeys("karnataka");
		driver.findElement(By.name("postalCode")).sendKeys("570023");
		
		Select select=new Select(driver.findElement(By.name("country")));
		select.selectByVisibleText("INDIA");
		
		System.out.println("The Select Drop Down has been Selected");
		
		driver.findElement(By.name("email")).sendKeys("Hemanth");
		driver.findElement(By.name("password")).sendKeys("Test");
		driver.findElement(By.name("confirmPassword")).sendKeys("Test");
		
		driver.findElement(By.name("submit")).click();
		
	    WebElement success= driver.findElement(By.xpath("(.//a)[15]"));
	    
	    WebDriverWait driverWait=new WebDriverWait(driver, 15);
	    driverWait.until(ExpectedConditions.visibilityOf(success));
	    
	    System.out.println(success);
	}
}

package basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestDemotwo {
	static WebDriver driver;
	static String baseURL="http://demo.guru99.com/selenium/webform/login.html";
	static String baseURL1="http://demo.guru99.com/selenium/webform/radio.html";
	static String baseURL2="http://demo.guru99.com/selenium/facebook.html";
	public static void main(String[] args) throws InterruptedException {
		TestDemotwo two=new TestDemotwo();
		
        driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		two.loginTest();
		System.out.println("Login Completed");
		
		two.radioButton();
		System.out.println("Radio Completed");
		
		two.facebookTest();
		System.out.println("FaceBook Completed");
		
		driver.quit();
		
		}
	
	public void loginTest()
	{
		try{
		driver.get(baseURL);
		driver.findElement(By.name("email")).sendKeys("Hemanth");
		driver.findElement(By.name("passwd")).sendKeys("Test");
		
		
		WebElement clicl=driver.findElement(By.name("SubmitLogin"));
		if(clicl.isEnabled())
		{
			clicl.click();
			WebElement actual=driver.findElement(By.xpath(".//*[@class='error-copy']/h3"));
			System.out.println("Test Passed :" +actual);
		}
		else
		{
			System.out.println("Test Failed");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void radioButton() throws InterruptedException
	{
		driver.get(baseURL1);
		
		driver.findElement(By.xpath(".//*[@id='vfb-7-1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='vfb-7-3']")).click();
		
		List<WebElement> check=driver.findElements(By.xpath(".//*[@type='checkbox']"));
		String[] link=new String[check.size()];
		for(int i=0;i<check.size();i++)
		{
			
			System.out.println(check.get(i));
			check.get(i).click();
		}
	}
	
	public void facebookTest()
	{
		driver.get(baseURL2);
		WebElement element=driver.findElement(By.xpath(".//*[@id='persist_box']"));
		for(int i=0;i<2;i++)
		{
			element.click();
		}
		System.out.println("Facebook Persists Checkbox Status is -  "+element.isSelected());
	}
}

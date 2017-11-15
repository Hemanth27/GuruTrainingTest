package basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Options {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/selenium/newtours/");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		
		String title="Under Construction: Mercury Tours";
		
		List<WebElement> linkElements=driver.findElements(By.tagName("a"));
		String[] linktexts=new String[linkElements.size()];
		int i=0;
		for(WebElement e : linkElements)
		{
			linktexts[i]=e.getText();
			i++;
		}
		
		for(String s: linktexts)
		{
			driver.findElement(By.linkText(s)).click();
			
			if(driver.getTitle().equalsIgnoreCase(title))
			{
				System.out.println("\"" + s + "\""								
                        + " is under construction.");	
			}
			else{
				System.out.println("\"" + s + "\""								
                        + " is working.");
			}
		}
		driver.close();
		
	
	}
}

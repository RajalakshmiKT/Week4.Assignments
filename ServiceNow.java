package week4.assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException 
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev119620.service-now.com/navpage.do");
		Thread.sleep(10000);
		driver.switchTo().frame("gsft_main");	
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Cktsrj@3");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Test Admin Incident");
		String incNo= driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println(incNo);

		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String>l=new ArrayList<String>(windowHandles);

		System.out.println( driver.getCurrentUrl());
		driver.switchTo().window(l.get(1));    
		System.out.println(l.get(1));
		driver.findElement(By.linkText("Abraham Lincoln")).click();
		Thread.sleep(2000);
		driver.switchTo().window(l.get(0)) ;
		System.out.println( driver.getCurrentUrl());
		System.out.println(l.get(0));

		driver.switchTo().frame("gsft_main");

		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incNo);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		String SearchIncNo = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println(SearchIncNo);
		if(incNo.equals(SearchIncNo))
		{
			System.out.println("Incident : " + SearchIncNo + " created and verified successfully");
		}
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(2000);
        File source=driver.getScreenshotAs(OutputType.FILE);
        String filename = "./src/main/resources/snaps/"+incNo+ ".png";
		File dest=new File(filename);
		FileUtils.copyFile(source, dest);
		
		
		
	}

}
package week4.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disappear {

	public static void main(String[] args) throws InterruptedException, IOException
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/disapper.html");
		Thread.sleep(2000);

		WebElement findElement = driver.findElement(By.xpath("//button[@id='btn']/b"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(findElement));        
		String text = driver.findElement(By.xpath("//div[@id='show']")).getText();
		if(text.contains("I know you can do it! Button is disappeared!"))
		{
			System.out.println(" Button is appeared after wait");
		}
		else
		{
			System.out.println(" Button is not appeared after wait");
		}
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/snaps/Img004.jpg");
		FileUtils.copyFile(source, dest);

	}
}

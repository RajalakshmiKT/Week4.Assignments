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

public class Appear {

	public static void main(String[] args) throws IOException 
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/appear.html");

		WebElement findElement = driver.findElement(By.xpath("//button[@id='btn']/b"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findElement));
		String text = findElement.getText();
		if(text.equals("Voila! I'm here Guys"))
		{
			System.out.println(text+ " " + "appeared after few seconds");
		}
		else
		{
			System.out.println(text + " " + "not appeared");
		}
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/snaps/Img005.jpg");
		FileUtils.copyFile(source, dest);

	}

}
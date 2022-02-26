package week4.assignments;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	
	public static void main(String[] args)
	{
		
				


	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/TextChange.html");
	
	WebElement Click= driver.findElement(By.xpath("//button[@class='btn']"));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.textToBePresentInElement(Click,"Click ME!"));
    Click.click();
    
    Alert alert = driver.switchTo().alert();
    String text = alert.getText();
    System.out.println(text);
    alert.accept();
}


}
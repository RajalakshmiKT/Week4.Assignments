package week4.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args)
	{
	   
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
        WebElement el1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
        WebElement el2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
        WebElement el3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
        WebElement el4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
        WebElement el5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
        WebElement el6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
        WebElement el7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(el2 , el1).dragAndDrop(el4, el3).dragAndDrop(el6, el5).perform();
        
	}
}
package week4.assignments;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCherFrames {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String text1 = driver.findElement(By.xpath("//h1[@class='breadcrumb-item']")).getText();
		System.out.println(text1);
		String text2 = driver.findElement(By.xpath("//label[@style='font-size:40px']/span")).getText();
		System.out.println(text2);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Frames");

		driver.switchTo().defaultContent();

		WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame);

		WebElement frame3= driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame3);

		driver.findElement(By.xpath("//input[@id='a']")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);

		WebElement animals = driver.findElement(By.id("animals"));
		Select animal=new Select(animals);
		animal.selectByIndex(1);



	}



}
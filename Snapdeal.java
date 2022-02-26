package week4.assignments;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException 
	{


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		WebElement findElement = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(findElement).build().perform();

		driver.findElement(By.xpath("(//span[@class='linkTest'])[1]")).click();
		Thread.sleep(3000);
		String sportshoes = driver.findElement(By.xpath("(//ul[@style='height: auto']//div)[3]")).getText();
		System.out.println(("Total number of sport shoes:="+ " "+ sportshoes));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//li[text()[normalize-space()='Price Low To High']]/preceding::i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[text()[normalize-space()='GO']]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();

		WebElement trainingShoes = driver.findElement(By.xpath("//p[@title='Red Tape Walking  Black Training Shoes']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(trainingShoes).perform();

		String price= driver.findElement(By.xpath("//span[@data-price='1099']")).getText();
		System.out.println("Price of the Training shoe is:=" +" "+ price);

		String discountPer = driver.findElement(By.xpath("//span[text()='83% Off']")).getText();
		System.out.println("Discount percentage :" + discountPer);

		File source=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./src/main/resources/snaps/Img005.jpg");
		FileUtils.copyFile(source, dest);

		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}



}
package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(brands).perform();

		WebElement searchbrands = driver.findElement(By.xpath("//input[@placeholder = 'search brands']"));
		actions.click(searchbrands).sendKeys("L'Oreal Paris").perform();
		driver.findElement(By.partialLinkText("L'Oreal Paris")).click();
		System.out.println("The Title is : " + driver.getTitle());

		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']")).click();
		driver.findElement(By.xpath("//div[@class='css-10zjw4o'][1]")).click();

		Set<String> window = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(window);
		String window1 = list.get(1);
		driver.switchTo().window(window1);
		WebElement ml = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select quantity = new Select(ml);
		quantity.selectByVisibleText("175ml");

		String price = driver.findElement(By.xpath("//span[@class='css-12x6n3h']")).getText();
		System.out.println("The MRP is : " + (price));
		driver.findElement(By.xpath("//span[text()='ADD TO BAG'][1]")).click();
		WebElement cart = driver.findElement(By.xpath("//button[@class = 'css-5s18zx eoh7kvv0']"));
		actions.moveToElement(cart).click().perform();
		driver.switchTo().frame(0);

		String total = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("The Grand Total is : " + total);
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		String grandTotal = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		System.out.println("The Grand Total in Basket is : " + grandTotal);

		String gtotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div")).getText();
		System.out.println("The Final Total is : " + gtotal);

		if (gtotal.equals(total)) {

			System.out.println("The  Grand Total is same ");

		}

		else {

			System.out.println("The Grand Total is different");

		}

	}

}

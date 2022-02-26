package week4.assignments;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLeafGround {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement snapshot = driver.findElement(By.xpath("(//button[text()='Click Me'])[1]"));
		snapshot.click();
		File source = snapshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/snaps/Img003.jpg");
		FileUtils.copyFile(source,dest);
		driver.switchTo().defaultContent();
		List<WebElement> numofframes = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of Frames = " + numofframes.size());

	}

}



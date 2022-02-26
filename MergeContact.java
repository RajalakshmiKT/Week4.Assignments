package week4.assignments;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	
	public static void main(String[] args) throws InterruptedException 
		{


			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.get("http://leaftaps.com/opentaps/control/main");
			driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.partialLinkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.linkText("Merge Contacts")).click();
			driver.findElement(By.xpath("//a[@href ='/crmsfa/control/mergeContactsForm']"));
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
			Set<String> windowHandles1 = driver.getWindowHandles();
			List<String> list1=new ArrayList<String>(windowHandles1);
			driver.switchTo().window(list1.get(1));
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
			driver.switchTo().window(list1.get(0));
			
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();//to
			Set<String> windowHandles2 = driver.getWindowHandles();
			List<String> l1=new ArrayList<String>(windowHandles2);
			driver.switchTo().window(l1.get(1));
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
			driver.switchTo().window(list1.get(0));
			driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
			Thread.sleep(2000);

			Alert alert=driver.switchTo().alert();
			String text = alert.getText();
			System.out.println(text);
			alert.accept();
			String currentUrl = driver.getCurrentUrl();  
			if(currentUrl.contains("viewContact"))
			{
				System.out.println("Title Verified");
			}

		}



		}







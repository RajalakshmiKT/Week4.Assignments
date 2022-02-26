package week4.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTableLeafGround {
	static String sort;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");

		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[2]"));
		ArrayList<String> givenlist = new ArrayList<String>(); 
		for(WebElement element : cols) {
			givenlist.add(element.getText());

		}

		System.out.println("The Given List is : " + givenlist);
		Collections.sort(givenlist);
		System.out.println("Sorting List using Sort Method : " + givenlist);
		driver.findElement(By.xpath("//th[text()='Name']")).click();

		List<WebElement> cols2 = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[2]"));
		ArrayList<String> sortedList = new ArrayList<String>(); 
		for(WebElement sort : cols2) {
			sortedList.add(sort.getText());
		}

		System.out.println("The Sorted List is : " + sortedList);
		if(sortedList.equals(givenlist)) {
			System.out.println("The Givent List is sorted");
		}
		else {
			System.out.println("The Given List is not sorted");

		}

	}

}



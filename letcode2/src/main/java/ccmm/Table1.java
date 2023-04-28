package ccmm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Open browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//Open the URL and click table button
		driver.get("https://letcode.in/table");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Print all headers name
		WebElement table = driver.findElement(By.id("simpletable"));
		List<WebElement> headers =table.findElements(By.tagName("th"));
		for (WebElement header : headers)	{
			String text = header.getText();
			System.out.println(text);
		}

		//Get size of row and check the correct size 
		List<WebElement> allrows = table.findElements(By.cssSelector("tbody tr"));
		int size = allrows.size();
		System.out.println("Rows size: " + size);
		if (size == 3) {
			System.out.println("Pass");
		}else System.out.println("Fail");

		//Print data of first column from  2nd row to last row
		/*for (WebElement row : allrows) {
			List<WebElement> columns =row.findElements(By.tagName("td"));	
			WebElement firstColumn = columns.get(0);
			System.out.println(firstColumn.getText());
      }*/
		
		//Mark Raj as present
		for (int i = 0; i< size; i++) {
		List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
			WebElement lastname = rows.get(1);
		String text = lastname.getText();
		System.out.println(text);
		if (text.equals("Chatterjee")) {
			WebElement input = rows.get(3).findElement(By.tagName("input"));
		input.click();
		break;
		}
		
		
		
		
		//Check if the sorting is working properly
int rowSize = 7;
		
		for (int a = 2; i<rowSize; a++) {
			WebElement fat = driver.findElement(By.xpath("//div[@class='card-conetnt']//tr[" + a + "]//td[2]"));
			WebElement carbs =driver.findElement(By.xpath("//div[@class='card-conetnt']//tr[" + a + "]//td[2]"));
		System.out.println(fat.getText());
		System.out.println(carbs.getText());
		}
		driver.quit();
		
		//driver.quit();
		
	}
	}

	
	}

	
	







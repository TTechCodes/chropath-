package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchTestTwo {

	public static void main(String[]args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sr71\\Desktop\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();

	//Case 1: Nothing entered
	searchTest(driver, " ", "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=&submit_search="); 
	
	//Case 2: List of expected terms example "dress"
	searchTest(driver, "dress", "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search="); 

	//Case 3: name from list does not appear
	searchTest(driver, "car", "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=car&submit_search="); 

	}
	
	private static void searchTest(WebDriver driver, String string, String expectedURL) throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(string);
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
		String currentURL = driver.getCurrentUrl();
			
		if(currentURL.equals(expectedURL)) {
				System.out.println("Case 3");
				System.out.println("Passed: Expected URL appears");		
		}else {
				System.out.println("Failed: URL did not appear");	
		}
		
		
		driver.findElement(By.xpath("//input[@id='search_query_top']")).clear();
		Thread.sleep(3000);

	}

  
}



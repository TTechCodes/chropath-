package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class emailTestTwo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sr71\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		
		//Case 1: invalid email format
		emailTest(driver,"qwert", "http://automationpractice.com/index.php?controller=authentication&back=my-account");

		//Case 2: valid format and email account exists 
		emailTest(driver,"qwert@gmail.com", "http://automationpractice.com/index.php?controller=authentication&back=my-account");

		//Case 3: valid format and email account does not exist
		emailTest(driver,"oknjh@gmail.com", "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");

		//Case 4: nothing entered 
		emailTest(driver," ", "http://automationpractice.com/index.php?controller=authentication&back=my-account");


	}
	
	private static void emailTest(WebDriver driver, String string, String expectedURL) {
		
		driver.get("http://automationpractice.com/index.php");
		
		WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		signIn.click();
		
	WebElement emailCreate = driver.findElement(By.xpath("//input[@id='email_create']"));
	emailCreate.sendKeys(string);
	driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]/span[1]")).click();
	String currentURL = driver.getCurrentUrl();
	
	if(currentURL.equals(expectedURL)) {
		System.out.println("Case 1");
		System.out.println("Passed: list tag displays invalid email");		
	}else {
		System.out.println("Failed: tag did not appear");
	emailCreate.clear();
	}
	}

}


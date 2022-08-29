package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testingAppTwo {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sr71\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
	
		
		//Sign In Check: nothing entered 
		signInTest(driver, " ", " ", "http://automationpractice.com/index.php?controller=authentication");

		//invalid email and password
		signInTest(driver, "asdf", "asdf", "http://automationpractice.com/index.php?controller=authentication");

		//Positive case 
		signInTest(driver, "poiu@gmail.com", "asdfg", "http://automationpractice.com/index.php?controller=my-account");
				
	}
	
		private static void signInTest(WebDriver driver, String email, String password, String expectedRegisterPageUrl) {
		driver.get("http://automationpractice.com/index.php");
		WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		signIn.click();
		
		WebElement acceptedSignIn = driver.findElement(By.xpath("//input[@id='email']"));
		acceptedSignIn.sendKeys(email);
		WebElement acceptPassword = driver.findElement(By.xpath("//input[@id='passwd']"));
		acceptPassword.sendKeys(password);
		WebElement signInConfirm2 = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
		signInConfirm2.click();
		
		String actualRegisterPageUrl = driver.getCurrentUrl();
	
		if(actualRegisterPageUrl.equals(expectedRegisterPageUrl)) {
			System.out.println("Passed: navigated to account site");
		}else {
			System.out.println("Failed: did not redirect to account site");
			System.out.println("Actual: "+ actualRegisterPageUrl);
			System.out.println("Expected: "+ expectedRegisterPageUrl);
		}
		

		}
	
	
}


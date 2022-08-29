package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class correctLinkTwo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sr71\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");
		
		String wrongURL = "https://www.prestashop.com/en";
		
		//Div 1
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]/img[1]")).click();
		System.out.println("Case 1");
		correctSite(driver.getCurrentUrl(),wrongURL);
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		//Div 2
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]/img[1]")).click();
		System.out.println("Case 2");
		correctSite(driver.getCurrentUrl(),wrongURL);
		
		Thread.sleep(3000);
		driver.navigate().back();

		//Div 3
		driver.findElement(By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[3]/a/img")).click();
		System.out.println("Case 3");
		correctSite(driver.getCurrentUrl(),wrongURL);
				
	}

	static void correctSite(String string1, String string2) {
		if(string2.equals(string1)) {
			System.out.println("Passed: Expected URL appears");		
	}else {
			System.out.println("Failed: URL did not appear");	
	}
		
	}
}


package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	
	
	public static WebDriver driver;
	
	public static void openBrowser(String URL){
		System.setProperty("webdriver.chrome.driver", "/Users/daniyalmistry/Desktop/selenium-2.53.1/chromedriver");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void goHome(){
		driver.navigate().to("http://dev01.juanregala.com.co/medellin/");
	}
	
	public static void isURLCorrect(String URL){
		if (driver==null)
			openBrowser(URL);
		
		String currentURL = driver.getCurrentUrl();
		if (currentURL==URL)
			System.out.println("correct URL");
		else
			driver.navigate().to(URL);

	}
	

}

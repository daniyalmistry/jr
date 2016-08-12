package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class example {
	@Test
	public void issue() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://dev01.juanregala.com.co/medellin/chocolates-domicilio-medellin/venta-bombones-chocolate");
		driver.findElement(By.xpath(".//*[@id='btn_buy_detail']")).click();
		Thread.sleep(6000);
		driver.navigate().to("http://dev01.juanregala.com.co/");
	}

}

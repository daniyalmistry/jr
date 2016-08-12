package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Browser;

public class cart {

	
	public static void emptyCart(){
		WebElement trash = Browser.driver.findElement(By.id("empty_cart_button"));
	
		trash.click();
	}
}

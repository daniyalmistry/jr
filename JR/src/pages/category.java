package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Browser;

public class category {
	
	public static void chooseItem (int nthITEM){
		WebElement item = Browser.driver.findElement(By.xpath("//*[@id='category-products-wrap dfghjkjhgfr']/div/div[2]/div/div[" + nthITEM + "]/div/div[2]/div[1]/div/a"));
		item.click();
	}
	
	public static void addTwo() throws InterruptedException{
		WebElement agregar1 = Browser.driver.findElement(By.xpath(".//*[@id='category-products-wrap dfghjkjhgfr']/div/div[2]/div/div[1]/div/div[2]/div[4]/button"));
		agregar1.click();
		Thread.sleep(2000);
		WebElement keepShopping = Browser.driver.findElement(By.id("modal_btn_continue_shopping"));
		keepShopping.click();
		Thread.sleep(2000);
		WebElement agregar2 = Browser.driver.findElement(By.xpath(".//*[@id='category-products-wrap dfghjkjhgfr']/div/div[2]/div/div[2]/div/div[2]/div[4]/button"));
		agregar2.click();
		Thread.sleep(2000);
		WebElement toCart = Browser.driver.findElement(By.id("modal_btn_go_to_cart"));
		toCart.click();
		Thread.sleep(2000);
		WebElement finalize = Browser.driver.findElement(By.xpath(".//*[@id='checkout_cart']/div[1]/ul/li/button"));
		finalize.click();
		Thread.sleep(2000);
	
	}

	public static void removeTwo() throws InterruptedException{
		WebElement agregar1 = Browser.driver.findElement(By.xpath(".//*[@id='category-products-wrap dfghjkjhgfr']/div/div[2]/div/div[1]/div/div[2]/div[4]/button"));		
		agregar1.click();
		Thread.sleep(2000);
		WebElement keepShopping = Browser.driver.findElement(By.id("modal_btn_continue_shopping"));
		keepShopping.click();
		Thread.sleep(2000);
		WebElement agregar2 = Browser.driver.findElement(By.xpath(".//*[@id='category-products-wrap dfghjkjhgfr']/div/div[2]/div/div[2]/div/div[2]/div[4]/button"));
		agregar2.click();
		Thread.sleep(2000);
		WebElement toCart = Browser.driver.findElement(By.id("modal_btn_go_to_cart"));
		toCart.click();
		Thread.sleep(2000);
		WebElement trash = Browser.driver.findElement(By.id("empty_cart_button"));
		trash.click();
	
	}
}



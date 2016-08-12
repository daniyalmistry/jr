package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Browser;

public class product {

	public static void addToCart(){
		WebElement cart = Browser.driver.findElement(By.id("btn_cart_detail"));
		
		cart.click();
		
		WebElement toCart = Browser.driver.findElement(By.id("modal_btn_go_to_cart"));
		toCart.click();
		
	}
	
	public static void comprar(){
		WebElement comprar = Browser.driver.findElement(By.id("btn_buy_detail"));
		comprar.click();
	}

	public static void checkSchedule() throws InterruptedException{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(Browser.driver,15);
		WebElement calenderInput = Browser.driver.findElement(By.id("calendar_input"));
		calenderInput.click();
		Thread.sleep(5000);
		WebElement date = Browser.driver.findElement(By.xpath("html/body/div[4]/div[1]/table/tbody/tr[5]/td[6]"));
		wait.until(ExpectedConditions.elementToBeClickable(date));
		date.click();
		
		WebElement selectSect = Browser.driver.findElement(By.xpath("//div[@id='sector_select']/div"));
		selectSect.click();
		Thread.sleep(2000);
		WebElement envigado = Browser.driver.findElement(By.xpath("//form[@id='calculator']/div[3]/div[2]/div[2]/div[2]"));
		Thread.sleep(2000);
		envigado.click();
		Thread.sleep(2000);

		WebElement submit = Browser.driver.findElement(By.id("calculator_btn"));
		submit.click();
		Thread.sleep(2000);

		WebElement close = Browser.driver.findElement(By.xpath("//span[@class='close-result']"));
		close.click();
			
	}
	
	public static void checkTabs() throws InterruptedException{
		WebElement additional = Browser.driver.findElement(By.xpath("//ul[@id='product_tab_nav']/li[2]/a"));
		WebElement reviews = Browser.driver.findElement(By.xpath("//ul[@id='product_tab_nav']/li[3]/a"));
		WebElement description = Browser.driver.findElement(By.xpath("//ul[@id='product_tab_nav']/li[1]/a"));
		
		additional.click();
		Thread.sleep(3000);
		reviews.click();
		Thread.sleep(3000);
		description.click();
		Thread.sleep(3000);

	}
	
	public static void writeReview(){
		WebElement reviews = Browser.driver.findElement(By.xpath("//a[@href='#tab_reviewform']"));
		WebElement toReviews = Browser.driver.findElement(By.xpath("//p[@id='review-form']/a[1]"));
		
		WebDriverWait wait = new WebDriverWait(Browser.driver,10);
		reviews.click();
		wait.until(ExpectedConditions.elementToBeClickable(toReviews));
		toReviews.click();
	}
}

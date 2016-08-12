package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Browser;

public class loginPage {

	public static void login(String emailaddy, String password){
		WebElement email = Browser.driver.findElement(By.id("email"));
		WebElement pass = Browser.driver.findElement(By.id("pass"));
		
		email.sendKeys(emailaddy);
		pass.sendKeys(password);
		pass.submit();
	}
	
	public static void goToCreate(){
		WebElement goToCrear = Browser.driver.findElement(By.xpath("//button[@title='Crear una Cuenta']"));
		goToCrear.click();
	}
	
	
}
//oscarugoster@gmail.com
//testing



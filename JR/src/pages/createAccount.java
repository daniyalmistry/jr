package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Browser;

public class createAccount {

	
	public static void crearCuenta(String fname, String lname, String typeOfDoc, String document, String maleorfemale, String emailaddy, String password){
		WebElement first = Browser.driver.findElement(By.id("firstname"));
		WebElement last = Browser.driver.findElement(By.id("lastname"));
		WebElement doctype = Browser.driver.findElement(By.id("document_type"));
		WebElement doc = Browser.driver.findElement(By.id("document"));
		WebElement male = Browser.driver.findElement(By.id("gender1"));
		WebElement female = Browser.driver.findElement(By.id("gender2"));
		WebElement email = Browser.driver.findElement(By.id("email_address"));
		WebElement pass = Browser.driver.findElement(By.id("password"));
		WebElement cpass = Browser.driver.findElement(By.id("confirmation"));
		WebElement create = Browser.driver.findElement(By.xpath("//button[@title='Crear Cuenta']"));
		
		first.sendKeys(fname);
		last.sendKeys(lname);
		
		Select documentType = new Select(doctype);
		if (typeOfDoc.equals("Cédula Colombiana"))
			documentType.selectByVisibleText("Cédula Colombiana");
		else if (typeOfDoc.equals("Cédula Extranjería"))
			documentType.selectByVisibleText("Cédula Extranjería");
		else if (typeOfDoc.equals("NIT"))
			documentType.selectByVisibleText("NIT");
		else if (typeOfDoc.equals("Tarjeta de Identidad"))
			documentType.selectByVisibleText("Tarjeta de Identidad");
		else if (typeOfDoc.equals("Pasaporte"))
			documentType.selectByVisibleText("Pasaporte");
		else if (typeOfDoc.equals("Registro Civil"))
			documentType.selectByVisibleText("Registro Civil");
		else if (typeOfDoc.equals("Número de Seguridad Social"))
			documentType.selectByVisibleText("Número de Seguridad Social");
		else if (typeOfDoc.equals("Licencia Conducción"))
			documentType.selectByVisibleText("Licencia Conducción");
		else if (typeOfDoc.equals("Identificación Impositiva"))
			documentType.selectByVisibleText("Identificación Impositiva");
		
		doc.sendKeys(document);
		
		if(maleorfemale.equals("male"))
			male.click();
		else
			female.click();
		
		email.sendKeys(emailaddy);
		
		pass.sendKeys(password);
		cpass.sendKeys(password);
		
		create.click();

	
		
	}
	
}



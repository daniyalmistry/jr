package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Browser;

public class checkout {

	public static void billingInfo (String typeOfDoc, String document, String emailaddy, String pass) throws InterruptedException{
		WebElement first = Browser.driver.findElement(By.id("billing:firstname"));
		WebElement last = Browser.driver.findElement(By.id("billing:lastname"));
		WebElement email = Browser.driver.findElement(By.id("billing:email"));
		WebElement phone = Browser.driver.findElement(By.id("billing:telephone"));
		WebElement male = Browser.driver.findElement(By.id("billing:gender1"));
		WebElement female = Browser.driver.findElement(By.id("billing:gender2"));
		WebElement distinct = Browser.driver.findElement(By.xpath(".//*[@id='mw_onstepcheckout_billing_form']/ul/li[10]/div/label"));
		
		Thread.sleep(10000);
		if (first.getAttribute("value").equals("")){
			WebElement login = Browser.driver.findElement(By.partialLinkText("registrarse"));
			login.click();
			Thread.sleep(2000);
			WebElement usern = Browser.driver.findElement(By.id("mini-login"));
			WebElement passn = Browser.driver.findElement(By.id("mini-password"));
			WebElement goLogin = Browser.driver.findElement(By.xpath("//input[@value='Iniciar Sesión']"));
				if(!usern.getAttribute("value").equals(""))
					usern.clear();
			usern.sendKeys(emailaddy);
				if(!passn.getAttribute("value").equals(""))
					passn.clear();
			passn.sendKeys(pass);
			goLogin.click();
				if(Browser.driver.getCurrentUrl().equals("http://dev01.juanregala.com.co/medellin/checkout/cart/")){
					WebElement empty = Browser.driver.findElement(By.xpath("//a[@title='Eliminar artículo']"));
					Thread.sleep(3000);
					Actions act = new Actions(Browser.driver);
					act.moveToElement(empty);
					empty.click();
					Thread.sleep(3000);
					WebElement close = Browser.driver.findElement(By.xpath(".//*[@id='ajax-messagebox']/div/a"));
					close.click();
					WebElement finalizar = Browser.driver.findElement(By.xpath("//button[@title='Finalizar Pedido']"));
					finalizar.click();
				}
		}
		
		WebElement doctype = Browser.driver.findElement(By.id("billing:document-type"));
		WebElement doc = Browser.driver.findElement(By.id("billing:document"));
		
		final String CC = "Cédula Colombiana";
		final String CE = "Cédula Extranjería";
		final String NIT = "NIT";
		final String TI = "Tarjeta de Identidad";
		final String PA = "Pasaporte";
		final String RC = "Registro Civil";
		final String NSS = "Número de Seguridad Social";
		final String LC = "Licencia Conducción";
		final String II = "Identificación Impositiva";

		Select dtype = new Select(doctype);
		switch(typeOfDoc){
			case CC:
				dtype.selectByVisibleText(CC);
				break;
			case CE:
				dtype.selectByVisibleText(CE);
				break;
			case NIT:
				dtype.selectByVisibleText(NIT);
				break;
			case TI:
				dtype.selectByVisibleText(TI);
				break;
			case PA:
				dtype.selectByVisibleText(PA);
				break;
			case RC:
				dtype.selectByVisibleText(RC);
				break;
			case NSS:
				dtype.selectByVisibleText(NSS);
				break;
			case LC:
				dtype.selectByVisibleText(LC);
				break;
			case II:
				dtype.selectByVisibleText(II);
				break;
			
		}
		
		doc.sendKeys(document);
		
			
		
	}
	public static void recipient(String type, String sector) throws InterruptedException{
		/*WebElement first = Browser.driver.findElement(By.id("shipping:firstname"));
		WebElement last = Browser.driver.findElement(By.id("shipping:lastname"));
		WebElement phone = Browser.driver.findElement(By.id("shipping:telephone"));
		WebElement street = Browser.driver.findElement(By.id("shipping:street1"));
		
		
		
*/
		
		WebElement street2 = Browser.driver.findElement(By.id("shipping:street2"));
		street2.sendKeys(type);
		
		Thread.sleep(3000);
		
		WebElement dropdown = Browser.driver.findElement(By.xpath(".//*[@id='sector']/div/div"));
		dropdown.click();
		WebElement textbox = Browser.driver.findElement(By.xpath(".//*[@id='shipping_address_form']/li[2]/div/div/div[1]/div[2]/div[1]/input"));
		textbox.sendKeys(sector, Keys.ENTER);
		WebElement textbox2 = Browser.driver.findElement(By.xpath(".//*[@id='shipping_address_form']/li[2]/div/div/div[1]/div[2]/div[1]/input"));
		textbox2.click();
		WebElement textbox3 = Browser.driver.findElement(By.xpath(".//*[@id='shipping_address_form']/li[2]/div/div/div[1]/div[2]/div[1]/input"));
		textbox3.sendKeys(Keys.ENTER);
		//WebElement paymentmethod = Browser.driver.findElement(By.id("p_method_placetopay_standard"));
		//paymentmethod.click();
		
		Thread.sleep(3000);

		WebElement calbutton = Browser.driver.findElement(By.xpath(".//*[@id='delivery_dates']/div[1]/div/span"));
		calbutton.click();
		Thread.sleep(3000);
		WebElement date = Browser.driver.findElement(By.xpath("html/body/div[7]/div[1]/table/tbody/tr[6]/td[3]"));
		date.click();
		
	}
	
	public static void submit(){
		WebElement accept = Browser.driver.findElement(By.id("id_accept_terms"));
		WebElement next = Browser.driver.findElement(By.xpath("//button[@title='Hacer un pedido']"));
		
		accept.click();
		next.click();
	}
	
	public static void submitPayemntMethod(){
		WebElement next = Browser.driver.findElement(By.id("//input[@name='btnProcess']"));
		
		next.click();
	}
	
	
	public static void Efecty(){
		WebElement efect = Browser.driver.findElement(By.id("p_method_paymentmodulepack_checkout"));
		efect.click();
	}
	
	public static void consig(){
		WebElement con = Browser.driver.findElement(By.id("p_method_paymentmodulepack"));
		con.click();
	}
	
	public static void coupon(String coupcode) throws InterruptedException{
		WebElement coup = Browser.driver.findElement(By.id("coupon_code"));
		WebElement button = Browser.driver.findElement(By.id("button-btn-coupon-id"));
		
		coup.sendKeys(coupcode);
		Thread.sleep(4000);
		button.click();
	}
	
	
	public static void gtfo(String fname, String lname, String emailaddy, String typeOfDoc, String document, String phoneNumber, String maleorfemale, String addy, String type, String sector, String pass, String phonenumber) throws InterruptedException{
		WebElement first = Browser.driver.findElement(By.id("billing:firstname"));
		WebElement last = Browser.driver.findElement(By.id("billing:lastname"));
		WebElement email = Browser.driver.findElement(By.id("billing:email"));
		WebElement doctype = Browser.driver.findElement(By.id("billing:document-type"));
		WebElement doc = Browser.driver.findElement(By.id("billing:document"));
		WebElement phone = Browser.driver.findElement(By.id("billing:telephone"));
		WebElement male = Browser.driver.findElement(By.id("billing:gender1"));
		WebElement female = Browser.driver.findElement(By.id("billing:gender2"));
		WebElement distinct = Browser.driver.findElement(By.xpath(".//*[@id='billing:need-billing-wrapper']/label"));
		
		if(phone.getAttribute("value").equals(phoneNumber))
			System.out.println("Already filled out");
		else{
		
		if(first.getAttribute("value").equals("") || first.getAttribute("value").equals(null)){
			first.sendKeys(fname);
			last.sendKeys(lname);
			email.sendKeys(emailaddy);
			
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
			
			phone.sendKeys(phoneNumber);
			
		}
		else {
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
		
			
			
			phone.sendKeys(phoneNumber);
			Thread.sleep(3000);
		}
		}
		
		
		doc.sendKeys(document);
		
		
		if(maleorfemale.equals("male"))
			male.click();
		else
			female.click();

		if(!distinct.getText().contains("Deseas generar una factura")){
			WebElement password = Browser.driver.findElement(By.id("register_new_account"));
			password.click();
		}
		else
			System.out.println("No need for password");
		
		//second box
		WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("co-shipping-resume-edit-btn")));
		if(Browser.driver.findElement(By.id("co-shipping-resume-edit-btn")).isDisplayed()==true)
			Browser.driver.findElement(By.id("co-shipping-resume-edit-btn")).click();		
		WebElement firstn = Browser.driver.findElement(By.id("shipping:firstname"));
		WebElement lastn = Browser.driver.findElement(By.id("shipping:lastname"));
		WebElement phonen = Browser.driver.findElement(By.id("shipping:telephone"));
		WebElement street = Browser.driver.findElement(By.id("shipping:street1"));
		WebElement street2 = Browser.driver.findElement(By.id("shipping:street2"));
		WebElement dropdown = Browser.driver.findElement(By.xpath(".//*[@id='sector']/div/div"));
		WebElement calbutton = Browser.driver.findElement(By.xpath(".//*[@id='delivery_dates']/div[1]/div/span"));
		if (first.getAttribute("value").equals(fname))
			System.out.println("Already filled out");
		else{
		firstn.sendKeys(fname);
		lastn.sendKeys(lname);
		phonen.sendKeys(phonenumber);
		street.clear();
		street.sendKeys(addy);
		street2.sendKeys(type);
		}
		dropdown.click();
		WebElement textbox = Browser.driver.findElement(By.xpath(".//*[@id='shipping_address_form']/li[2]/div/div/div[1]/div[2]/div[1]/input"));
		textbox.sendKeys(sector,Keys.ENTER);
		//textbox.click();
		calbutton.click();
		Thread.sleep(2000);
		WebElement date = Browser.driver.findElement(By.xpath("html/body/div[7]/div[1]/table/tbody/tr[6]/td[3]"));
		date.click();
	}
	
	//Alert alert = Browser.driver.switchTo().alert();

	
}

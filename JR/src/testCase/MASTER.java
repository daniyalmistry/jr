package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.cart;
import pages.category;
import pages.checkout;
import pages.createAccount;
import pages.home;
import pages.loginPage;
import pages.product;
import utility.Browser;
import utility.commonRepeats;

public class MASTER {
	
	int i = 0;
	String firstname = "Oscar";
	String lastname = "Gomez";
	String emailaddress="sample2@gmail.com";
	String createacctemail="testtest" + i + "@gmail.com";
	String typeOfDocument="Cédula Colombiana";
	String docnumber = "3245676578";
	String phonenumb = "0000000000";
	String gender = "male";
	String passwrd = "testing";
	String address = "calle 98 sur 59-20";
	String typeofhouse = "casa";
	String sector = "envigado";
	String categoryHome = "flores";
	int indexProduct = 5;
	
	final boolean initiate = true;
	final boolean addProductToCart = true;
	final boolean emptyCart = true;
	final boolean comprar = true;
	final boolean schedule = true;
	final boolean tabs = true;
	final boolean review = true;
	final boolean accountCreate = true;
	final boolean creditCard = true;
	final boolean efecty = true;
	final boolean consig = true;
	final boolean coupon = true;
	final boolean twoToCart = true;
	final boolean twoFromCart = true;

	
	
	@AfterSuite (enabled=true)
	public static void close() throws InterruptedException{
		Thread.sleep(10000);
		//Browser.driver.quit();
	}
	
	
	
	@Test(enabled=initiate, priority=0)
	public void initiate() throws InterruptedException{
		Browser.openBrowser("http://dev01.juanregala.com.co/");
	}
	
	@Test(enabled=addProductToCart, priority=1)
	public void addProductToCart() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		commonRepeats.goToCart(categoryHome,indexProduct);
	
	}
	
	@Test(enabled=emptyCart, priority=2)
	public void emptyCart() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		commonRepeats.goToCart(categoryHome, indexProduct);
		cart.emptyCart();
		
	}
	
	@Test(enabled=comprar, priority=3)
	public void comprar() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		commonRepeats.goToProduct(categoryHome, indexProduct);
		product.comprar();
		Thread.sleep(5000);
		checkout.gtfo(firstname, lastname, emailaddress, typeOfDocument, docnumber, phonenumb, gender, address, typeOfDocument, sector, passwrd, phonenumb);
		Thread.sleep(10000);

	}
	
	@Test(enabled=schedule, priority=4)
	public void schedule() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Thread.sleep(3000);
		commonRepeats.goToProduct(categoryHome, indexProduct);
		product.checkSchedule();
	}
	
	@Test(enabled=tabs, priority=5)
	public void tabs() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Thread.sleep(3000);
		commonRepeats.goToProduct(categoryHome, indexProduct);
		product.checkTabs();

	}
	
	@Test(enabled=review, priority=6)
	public void review() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Thread.sleep(3000);
		commonRepeats.goToProduct(categoryHome, indexProduct);
		product.writeReview();
		loginPage.login("oscarugoster@gmail.com", passwrd);
		Browser.isURLCorrect("http://dev01.juanregala.com.co/");
		Browser.driver.navigate().to("http://dev01.juanregala.com.co/");
		Thread.sleep(10000);
	}
	
	@Test(enabled=accountCreate, priority=7)
	public void accountCreate() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/");
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Thread.sleep(3000);
		home.signOut();
		Thread.sleep(3000);
		home.yourAccount();
		loginPage.goToCreate();
		createAccount.crearCuenta(firstname, lastname, typeOfDocument, docnumber, gender, createacctemail, passwrd);
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		home.signOut();
	}
	
	@Test(enabled=creditCard, priority=8)
	public void creditCard() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Thread.sleep(2000);
		home.clearCart();
		Thread.sleep(2000);
		commonRepeats.goToProduct(categoryHome, indexProduct);
		product.comprar();
		Thread.sleep(3000);
		
		checkout.billingInfo(typeOfDocument, docnumber, emailaddress, passwrd);
		checkout.recipient(typeofhouse, sector);
		Thread.sleep(13000);
		checkout.submit();
		JavascriptExecutor executor = (JavascriptExecutor)Browser.driver;
				executor.executeScript("window.alert = function () { return true}");
	
	}
	
	@Test(enabled=efecty, priority=9)
	public void efecty() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Thread.sleep(3000);
		home.clearCart();
		Thread.sleep(3000);
		commonRepeats.goToProduct(categoryHome, indexProduct);
		product.comprar();
		Thread.sleep(3000);
		
		checkout.billingInfo(typeOfDocument, docnumber, emailaddress, passwrd);
		checkout.recipient(typeofhouse, sector);
		checkout.Efecty();
		Thread.sleep(3000);
		checkout.submit();
		 
		JavascriptExecutor executor = (JavascriptExecutor)Browser.driver;
		executor.executeScript("window.alert = function () { return true}");
	}
	
	@Test(enabled=consig, priority=10)
	public void consig() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Thread.sleep(3000);
		//home.clearCart();
		Thread.sleep(3000);
		commonRepeats.goToProduct(categoryHome, indexProduct);
		product.comprar();
		Thread.sleep(3000);
		
		checkout.billingInfo(typeOfDocument, docnumber, emailaddress, passwrd);
		checkout.recipient(typeofhouse, sector);
		checkout.consig();
		Thread.sleep(3000);
		checkout.submit();
		JavascriptExecutor executor = (JavascriptExecutor)Browser.driver;
		executor.executeScript("window.alert = function () { return true}");
		 		
	}
	
	
	@Test(enabled=coupon, priority=11)
	public void coupon() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Thread.sleep(3000);
	//	home.clearCart();
		Thread.sleep(3000);
		commonRepeats.goToProduct(categoryHome, indexProduct);
		product.comprar();
		Thread.sleep(3000);
		
		checkout.billingInfo(typeOfDocument, docnumber, emailaddress, passwrd);
		checkout.recipient(typeofhouse, sector);
		Thread.sleep(3000);
		checkout.coupon("TEST10");
		Thread.sleep(3000);
		checkout.submit();
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor)Browser.driver;
		executor.executeScript("window.alert = function () { return true}");
	
		
	}
	
	@Test(enabled=twoToCart, priority=12)
	public void twoToCart() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Thread.sleep(3000);
		home.chooseCategory(categoryHome);
		category.addTwo();
	}
	
	@Test(enabled=twoFromCart, priority=13)
	public void twoFromCart() throws InterruptedException{
		Browser.isURLCorrect("http://dev01.juanregala.com.co/medellin/");
		Thread.sleep(3000);
		home.chooseCategory(categoryHome);
		category.removeTwo();
	}
}

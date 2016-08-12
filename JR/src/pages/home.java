package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Browser;

public class home {

	
	public static void search (String query){
		WebElement sbox = Browser.driver.findElement(By.id("search"));
		
		sbox.sendKeys(query);
	}
	
	public static void chooseCategory(String category) throws InterruptedException{
		Thread.sleep(3000);
		WebElement flores = Browser.driver.findElement(By.xpath("//a[@href='/medellin/ramos-flores-medellin']"));
		WebElement chocolates = Browser.driver.findElement(By.xpath("//a[@href='/medellin/chocolates-domicilio-medellin']"));
		WebElement anchetas = Browser.driver.findElement(By.xpath("//a[@href='/medellin/anchetas-dulces-medellin']"));
		WebElement desayuno = Browser.driver.findElement(By.xpath("//a[@href='/medellin/desayunos-sorpresa-medellin']"));
		WebElement arreglosFrutales = Browser.driver.findElement(By.xpath("//a[@href='/medellin/arreglos-frutales-medellin']"));
		WebElement cupcakes = Browser.driver.findElement(By.xpath("//a[@href='/medellin/cupcakes-medellin']"));
		WebElement ocasiones = Browser.driver.findElement(By.xpath("//a[@href='/medellin/regalos-amor-amistad-medellin']"));
		WebElement novio = Browser.driver.findElement(By.xpath("//a[@href='/medellin/regalos-novio-medellin']"));
		WebElement peluches = Browser.driver.findElement(By.xpath("//a[@href='/medellin/peluches-medellin']"));
		
		if (category.contains("flores"))
			flores.click();
		else if (category.contains("chocolates"))
			chocolates.click();
		else if (category.contains("anchetas"))
			anchetas.click();
		else if (category.contains("desayuno"))
			desayuno.click();
		else if (category.contains("frutales"))
			arreglosFrutales.click();
		else if (category.contains("cupcake"))
			cupcakes.click();
		else if (category.contains("ocasiones"))
			ocasiones.click();
		else if (category.contains("Románticos"))
			novio.click();
		else if (category.contains("peluches"))
			peluches.click();
		else
			System.out.println("The options are flores, chocolates, anchetas, desayuno, frutales, cupcake, ocasiones, Románticos, peluches");
	}

	public static void yourAccount(){
		WebElement miCuenta = Browser.driver.findElement(By.linkText("Mi cuenta"));
		
		miCuenta.click();
	}
	
	public static void yourCart(){
		WebElement miCarrito = Browser.driver.findElement(By.linkText("Mi carrito"));
		
		miCarrito.click();
	}
	
	public static void logIn(){
		WebElement logIn = Browser.driver.findElement(By.xpath("//a[@title='Iniciar Sesión']"));
		
		logIn.click();
	}
	
	public static void signOut(){
		WebElement logoutlogin = Browser.driver.findElement(By.xpath(".//*[@id='et_theme_wrapper']/div/div[1]/div/div[1]/div/div/div[2]/div[2]/span/a"));
		if (logoutlogin.getAttribute("title").equals("Cerrar Sesión")){
			logoutlogin.click();
		}
	}
	
	public static void clearCart(){
		WebElement itemNum = Browser.driver.findElement(By.xpath("//span[@class='badge']"));
		
		if(!itemNum.getText().contains("0")){
			WebElement carrito = Browser.driver.findElement(By.xpath("//a[@title='Mi carrito']"));
			carrito.click();
			cart.emptyCart();
		}
		
		
	}
}

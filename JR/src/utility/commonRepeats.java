package utility;


import pages.category;
import pages.home;
import pages.product;

public class commonRepeats {

	public static void goToCart(String Category, int nthITEM) throws InterruptedException{
		home.chooseCategory(Category);
		category.chooseItem(nthITEM);
		product.addToCart();
	}
	
	public static void goToProduct(String Category, int nthITEM) throws InterruptedException{
		home.chooseCategory(Category);
		category.chooseItem(nthITEM);
	}
	
	
}

package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class Opening 
{
	public By LOGIN = By.xpath("//*[@id=\"login2\"]");
	public By LOGINBTN = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
	public By PHONE = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a");
	public By ADDTOCART = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
	public By CART = By.xpath("//*[@id=\"cartur\"]");
	public By LAPTOPPAGE = By.xpath("/html/body/div[5]/div/div[1]/div/a[3]");
	public By LAPTOP = By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a");
	public By MONITORPAGE = By.xpath("/html/body/div[5]/div/div[1]/div/a[4]");
	public By MONITOR = By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a");
	public By HOME = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");
	public By HOMEE = By.xpath("/html/body/nav/div/div/ul/li[1]/a");


	WebDriver driver = null;


	@Given("User is on Home page")
	public void user_is_on_home_page() throws InterruptedException{
		startChrome();
		login();
	}

	@Then("User views the list of products")
	public void user_views_the_list_of_products() throws InterruptedException {
		scroll();
	}

	@Then("User views details of product")
	public void user_views_details_of_product()throws InterruptedException {
		//View phone details
		WebElement shop =driver.findElement(PHONE);
		shop.click();
		Thread.sleep(4000);
		
		//Adding phone to cart
		WebElement cart =driver.findElement(ADDTOCART);
		cart.click();
		Thread.sleep(4000);
		
		//Acknowledging the alert
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		//Home screen
		WebElement home =driver.findElement(HOME);
		home.click();
		Thread.sleep(4000);

		//Redirecting to laptop page
		WebElement laptop_page =driver.findElement(LAPTOPPAGE);
		laptop_page.click();
		Thread.sleep(4000);
		scroll();
		
		//View laptop details
		WebElement laptop =driver.findElement(LAPTOP);
		laptop.click();
		Thread.sleep(4000);
		
		//Adding laptop to cart
		WebElement laptop_cart =driver.findElement(ADDTOCART);
		laptop_cart.click();
		Thread.sleep(4000);
		
		//Acknowledging the alert
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		//Home screen
		WebElement homee =driver.findElement(HOMEE);
		homee.click();
		Thread.sleep(4000);

		//Redirecting to Monitor page
		WebElement monitor_page =driver.findElement(MONITORPAGE);
		monitor_page.click();
		Thread.sleep(4000);
		scroll();
		
		//View monitor details
		WebElement monitor =driver.findElement(MONITOR);
		monitor.click();
		Thread.sleep(4000);
		
		//Adding monitor to cart
		WebElement monitor_cart =driver.findElement(ADDTOCART);
		monitor_cart.click();
		Thread.sleep(4000);
		
		//Acknowledging the alert
		driver.switchTo().alert().accept();
		Thread.sleep(3000);


	}

	@Then("User adds product to cart")
	public void user_adds_product_to_cart() throws InterruptedException{
		//Viewing the cart
		WebElement cart =driver.findElement(CART);
		cart.click();
		Thread.sleep(4000);


	}

	@Then("User checkout and completes payment")
	public void user_checkout_and_completes_payment() throws InterruptedException{
		//Placing order
		WebElement placeOrder =driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
		placeOrder.click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Dummy User");
		Thread.sleep(1000);
		driver.findElement(By.id("country")).sendKeys("India");
		Thread.sleep(1000);
		driver.findElement(By.id("city")).sendKeys("Mumbai");
		Thread.sleep(1000);
		driver.findElement(By.id("card")).sendKeys("4568 7458 1245 1254");
		Thread.sleep(1000);
		driver.findElement(By.id("month")).sendKeys("12");
		Thread.sleep(1000);
		driver.findElement(By.id("year")).sendKeys("2034");
		Thread.sleep(2000);
		
		//Clicking Purchase
		WebElement purchase =driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
		purchase.click();
		Thread.sleep(2000);
		WebElement okay =driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button"));
		okay.click();
		Thread.sleep(2000);

		//Logging out
		WebElement logout =driver.findElement(By.xpath("//*[@id=\"logout2\"]"));
		logout.click();
		Thread.sleep(2000);

		//Closing browser
		driver.close();
	}
	
	public void startChrome() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void scroll() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, (document.body.scrollHeight)/2)");
		Thread.sleep(2000);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollTo((document.body.scrollHeight)/2, (document.body.scrollHeight))");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("");
		Thread.sleep(4000);
		js.executeScript("scroll(0, -250);");
		Thread.sleep(4000);
	}
	
	public void login() throws InterruptedException{
		driver.navigate().to("https://www.demoblaze.com/index.html");
		Thread.sleep(3000);
		System.out.println("User clicks on login button");
		WebElement login = driver.findElement(LOGIN);
		login.click();
		Thread.sleep(3000);
		driver.findElement(By.id("loginusername")).sendKeys("dummyAcc");
		Thread.sleep(1000);
		driver.findElement(By.id("loginpassword")).sendKeys("123");
		WebElement loginbtn = driver.findElement((LOGINBTN));
		Thread.sleep(3000);
		loginbtn.click();
		Thread.sleep(5000);
	}


}	

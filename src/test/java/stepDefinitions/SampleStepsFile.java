package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SampleStepsFile {

	static WebDriver driver;

	@Given("user is navigate to {string}")
	public void user_is_navigate_to(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@And("enter username {string} and password {string}")
	public void EnterUsernameAndPassword(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

	}

	@And("user is able to click on Login button")
	public void user_is_able_to_click_on_login_button() {

		driver.findElement(By.id("login-button")).click();
	}

	@Then("user is able to Navigate and see saucedemo page")
	public void user_is_able_to_navigate_and_see_saucedemo_page() throws InterruptedException {

		WebElement ExpectedTitle = driver.findElement(By.xpath("//div[@class='product_label']"));
		String actual = ExpectedTitle.getText();
		String expected = "Products";
		Assert.assertEquals(actual, expected);
		// driver.close();
		Thread.sleep(3000);
	}

	@Given("user is to open DropDownTab")
	public void user_is_to_open_DropDownTab() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select select = new Select(dropdown);
		select.selectByIndex(0);
		Thread.sleep(3000);
		select.selectByIndex(1);
		Thread.sleep(3000);
		select.selectByIndex(2);
		Thread.sleep(3000);
		select.selectByIndex(3);

	}

	@And("select the maximum price-product")
	public void select_the_maximum_priceproduct() {
		WebElement maximumproduct = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Fleece Jacket')]"));
		Actions action = new Actions(driver);
		action.moveToElement(maximumproduct).build().perform();
		action.click(maximumproduct).build().perform();
	}

	@And("select the product and verify price")
	public void select_the_product_and_verify_price() {
		WebElement productprice = driver.findElement(By.xpath("//div[@class='inventory_details_price']"));

		String actauldata = productprice.getText();
		String Expecteddata = "$49.99";
		Assert.assertEquals(actauldata, Expecteddata);

	}

	@And("select the add-to-cart webelement")
	public void select_the_add_to_cart_webelement() {
		WebElement addtocart = driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]"));
		Actions action = new Actions(driver);
		action.moveToElement(addtocart).build().perform();
		action.click(addtocart).build().perform();
	}

	@And("user is able to see and verify that RedDotNumber")
	public void user_is_able_to_see_and_verify_that_RedDotNumber() {
		WebElement redDot = driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']"));
		String actauldata = redDot.getText();
		String Expecteddata = "1";
		Assert.assertEquals(actauldata, Expecteddata);
	}

	@And("user is able to remove the item from addto cart")
	public void user_is_able_to_remove_the_item_from_addtocart() throws InterruptedException {
		WebElement Removeaddtocart = driver.findElement(By.xpath("//button[@class='btn_secondary btn_inventory']"));
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(Removeaddtocart).build().perform();
		action.click(Removeaddtocart).build().perform();
		driver.close();

	}
}

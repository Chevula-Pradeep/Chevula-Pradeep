package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SampleStepsFile {

    static WebDriver driver;

    @Given("user is navigate to {string}")
    public void user_is_navigate_to(String url) {
         WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
        driver.get(url);
    }

    @And("user is able to see and enter username is \"standard_user\"")
    public void userIsAbleToSeeAndEnterUsername(String username) {
        WebElement myusername = driver.findElement(By.id("username"));
        myusername.sendKeys("standard_user");
    }

    @And("user is able to see and enter password is \"secret_sauce\"")
    public void userIsAbleToSeeAndEnterPassword(String password) {
        WebElement mypassword = driver.findElement(By.id("password"));
        mypassword.sendKeys("secret_sauce");
    }


    @And("user is able to click on Login button")
    public void user_is_able_to_click_on_login_button() {

        driver.findElement(By.id("loginButton")).click();
    }

    @Then("user is able to Navigate and see saucedemo page")
    public void user_is_able_to_navigate_and_see_saucedemo_page() {

        String pageTitle = driver.getTitle();
        Assert.assertEquals("Expected Page Title", pageTitle);
    }










}

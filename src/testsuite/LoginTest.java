package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find the username field 
        WebElement usernameField = driver.findElement(By.id("username"));
       usernameField.sendKeys("tomsmith");

        //find the password field and type the password to  password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //find the login btn element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedText = "Secure Area";
        //find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Secure Area",expectedText,actualText);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //find the username field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith1");

        //find the password field and type the password to  password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //find the login btn element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedText = "Your username is invalid!";
        //find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Your username is invalid!",expectedText,actualText);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //find the username field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        //find the password field and type the password to  password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        //find the login btn element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedText = "Your password is invalid!";
        //find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Your password is invalid!",expectedText,actualText);
    }
    @After
    public void tearDown () {
        closeBrowser();

    }

}

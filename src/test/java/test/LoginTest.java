package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.maxsoft.extentreport.DriverHolder.getDriver;
import static com.maxsoft.extentreport.DriverHolder.setDriver;
import static com.maxsoft.extentreport.PropertyFileReader.getProperty;
import static org.testng.Assert.assertEquals;

/**
 * Project Name    : maxsoft-extent-reporter
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 11/21/2020
 * Time            : 12:38 PM
 * Description     : This is a test class to test the login functionality
 **/

public class LoginTest {

    private WebDriver driver;
    private WebElement emailTextBox;
    private WebElement passwordTextBox;
    private WebElement signInButton;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        setDriver(driver);
        driver.manage().window().maximize();
        driver.get(getProperty("application_url"));
        emailTextBox = driver.findElement(By.id("email"));
        passwordTextBox = driver.findElement(By.id("passwd"));
        signInButton = driver.findElement(By.id("SubmitLogin"));
    }

    @Test(description = "Verify that a valid user can login to the application")
    public void testValidLogin() {
        emailTextBox.sendKeys("osanda@mailinator.com");
        passwordTextBox.sendKeys("1qaz2wsx@");
        signInButton.click();
        assertEquals(driver.findElement(By.xpath("//div[@class='header_user_info']//span")).getText(), "Osanda Nimalarathn");
    }

    @AfterMethod
    public void after() {
        getDriver().quit();
    }
}

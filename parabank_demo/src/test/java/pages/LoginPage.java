package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginBtn = By.xpath("//input[@value='Log In']");

    public void login(String username, String password) {

        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginBtn).click();
    }
}
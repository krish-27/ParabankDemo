package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage {

    WebDriver driver;

    public AccountOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    By balance = By.xpath("(//table[@id='accountTable']//td)[2]");

    public void printAccountBalance() {

        String accountBalance = driver.findElement(balance).getText();

        System.out.println("Account Balance is : " + accountBalance);
    }
}
package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.AccountOverviewPage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.DriverFactory;

public class SignupSteps {

    WebDriver driver;

    RegisterPage registerPage;
    LoginPage loginPage;
    AccountOverviewPage accountOverviewPage;

    String username = "user" + System.currentTimeMillis();
    String password = "Test@123";

    @Given("User launches Parabank application")
    public void launchApplication() {

        driver = DriverFactory.initializeBrowser();

        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }

    @When("User clicks on Register link")
    public void clickRegister() {

        driver.findElement(By.linkText("Register")).click();
    }

    @When("User enters valid registration details")
    public void enterRegistrationDetails() {

        registerPage = new RegisterPage(driver);

        registerPage.enterRegistrationDetails(username, password);
    }

    @When("User submits registration form")
    public void submitRegistrationForm() {

        registerPage.clickRegister();
    }

    @Then("Account should be created successfully")
    public void verifyAccountCreation() {

        String successMessage = driver.getPageSource();

        if (successMessage.contains("Your account was created successfully")) {

            System.out.println("Account created successfully");
        }
    }

    @When("User logs out from application")
    public void logout() {

        driver.findElement(By.linkText("Log Out")).click();
    }

    @When("User logs in with newly created credentials")
    public void loginWithNewCredentials() {

        loginPage = new LoginPage(driver);

        loginPage.login(username, password);
    }

    @Then("User should login successfully")
    public void verifyLogin() {

        String title = driver.getPageSource();

        if (title.contains("Accounts Overview")) {

            System.out.println("Login successful");
        }
    }

    @Then("User prints the account balance")
    public void printBalance() {
        // Check balance
        accountOverviewPage = new AccountOverviewPage(driver);

        accountOverviewPage.printAccountBalance();

        driver.quit();

    }
}
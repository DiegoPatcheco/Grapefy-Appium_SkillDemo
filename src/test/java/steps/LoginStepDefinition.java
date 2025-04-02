package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import pages.LoginPage;
import utilities.CommonFlows;

public class LoginStepDefinition {
    private final CommonFlows commonFlows = new CommonFlows();
    private final LoginPage loginPage = new LoginPage();

    @Given("The user navigates to the Login screen")
    public void navigateLoginScreen() {
        commonFlows.goToLoginPage();
    }

    @When("The user verifies the Login screen elements")
    public void verifyLoginScreenElements() {
        loginPage.verifyPage();
    }

    @When("The user verifies the Sign Up screen elements")
    public void verifySignUpScreenElements() {
        loginPage.verifySignUpForm();
    }

    @When("The user fills the Login form with valid data")
    public void fillLoginFormValidData() {
        final var user = new User();
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
    }

    @Then("The user verifies the Login success message")
    public void verifyLoginSuccessMessage() {
        loginPage.verifyLoginSuccessMessage();
        loginPage.waitPageToLoad();
    }

    @When("The user fills the Login form with invalid data: {string} email, {string} password")
    public void fillLoginFormWithInvalidData(String email, String password) {
        loginPage.fillLoginForm(email, password);
    }

    @When("The user fills the Sign Up form with invalid data: {string} email, {string} password, {string} password confirm")
    public void fillSignUpFormWithInvalidData(String email, String password, String pwdConfirm) {
        loginPage.fillSignUpForm(email, password, pwdConfirm);
    }

    @Then("The user verifies the Login error message: {string}")
    public void verifyErrorMessage(String errorMessage) {
        loginPage.verifyErrorMessage(errorMessage);
    }
}

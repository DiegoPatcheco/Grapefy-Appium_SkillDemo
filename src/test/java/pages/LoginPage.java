package pages;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {
    private final By emailLoginInput = AppiumBy.accessibilityId("input-email");
    private final By passwordLoginInput = AppiumBy.accessibilityId("input-password");
    private final By loginButton = AppiumBy.accessibilityId("button-LOGIN");
    private final By signUpFormButton = AppiumBy.accessibilityId("button-sign-up-container");
    private final By emailSignUpInput = AppiumBy.accessibilityId("input-email");
    private final By passwordSignUpInput = AppiumBy.accessibilityId("input-password");
    private final By pwdConfirmSignUpInput = AppiumBy.accessibilityId("input-repeat-password");
    private final By signUpButton = AppiumBy.accessibilityId("button-SIGN UP");
    private final By successTitle = AppiumBy.id("android:id/alertTitle");
    private final By successDescription = AppiumBy.id("android:id/message");
    private final By successConfirmButton = AppiumBy.id("android:id/button1");
    private final String errorMessageLocator = "text(\"%s\")";

    @Override
    public void waitPageToLoad() {
        waitPage(emailLoginInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verify login page elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(emailLoginInput).isDisplayed()),
                () -> Assertions.assertTrue(find(passwordLoginInput).isDisplayed()),
                () -> Assertions.assertTrue(find(loginButton).isDisplayed())
        );
    }

    public void verifySignUpForm() {
        Logs.info("Click on sign up form button");
        find(signUpFormButton).click();

        Logs.info("Verify signup form elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(emailSignUpInput).isDisplayed()),
                () -> Assertions.assertTrue(find(passwordSignUpInput).isDisplayed()),
                () -> Assertions.assertTrue(find(pwdConfirmSignUpInput).isDisplayed()),
                () -> Assertions.assertTrue(find(signUpButton).isDisplayed())
        );
    }

    public void fillLoginForm(String email, String password) {
        Logs.info("Enter email");
        find(emailLoginInput).sendKeys(email);

        Logs.info("Enter password");
        find(passwordLoginInput).sendKeys(password);

        Logs.info("Click on login button");
        find(loginButton).click();
    }

    public void fillSignUpForm(String email, String password, String pwdConfirm) {
        Logs.info("Go to sign up form");
        find(signUpFormButton).click();

        Logs.info("Enter email");
        waitForDisplayed(emailSignUpInput).sendKeys(email);

        Logs.info("Enter password");
        find(passwordSignUpInput).sendKeys(password);

        Logs.info("Confirm password");
        find(pwdConfirmSignUpInput).sendKeys(pwdConfirm);

        Logs.info("Click on sign up button");
        find(signUpButton).click();
    }

    public void verifyLoginSuccessMessage() {
        Logs.info("Verify success message");
        Assertions.assertAll(
                () -> Assertions.assertTrue(waitForDisplayed(successTitle).isDisplayed()),
                () -> Assertions.assertTrue(find(successDescription).isDisplayed()),
                () -> Assertions.assertTrue(find(successConfirmButton).isDisplayed())
        );

        Logs.info("Click on success confirm button");
        find(successConfirmButton).click();
    }

    public void verifyErrorMessage(String errorMessage) {
        Logs.info("Verify error message");
        final var errorMessageLabel = AppiumBy.androidUIAutomator(
                String.format(errorMessageLocator, errorMessage));

        Assertions.assertAll(
                () -> Assertions.assertTrue(waitForDisplayed(errorMessageLabel).isDisplayed()),
                () -> Assertions.assertEquals(find(errorMessageLabel).getText(), errorMessage)
        );
    }
}

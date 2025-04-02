package pages;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class BottomBar extends BasePage {
    private final By homeButton = AppiumBy.accessibilityId("Home");
    private final By webViewButton = AppiumBy.accessibilityId("Webview");
    private final By loginButton = AppiumBy.accessibilityId("Login");
    private final By formsButton = AppiumBy.accessibilityId("Forms");
    private final By swipeButton = AppiumBy.accessibilityId("Swipe");
    private final By dragButton = AppiumBy.accessibilityId("Drag");

    @Override
    public void waitPageToLoad() {
        waitPage(homeButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verify bottom bar elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(homeButton).isDisplayed()),
                () -> Assertions.assertTrue(find(webViewButton).isDisplayed()),
                () -> Assertions.assertTrue(find(loginButton).isDisplayed()),
                () -> Assertions.assertTrue(find(formsButton).isDisplayed()),
                () -> Assertions.assertTrue(find(swipeButton).isDisplayed()),
                () -> Assertions.assertTrue(find(dragButton).isDisplayed())
        );
    }

    public void goToHomeScreen() {
        Logs.info("Navigate to home screen");
        find(homeButton).click();
    }

    public void goToWebViewScreen() {
        Logs.info("Navigate to web view screen");
        find(webViewButton).click();
    }

    public void goToLoginScreen() {
        Logs.info("Navigate to login screen");
        find(loginButton).click();
    }

    public void goToFormsScreen() {
        Logs.info("Navigate to forms screen");
        find(formsButton).click();
    }

    public void goToSwipeScreen() {
        Logs.info("Navigate to swipe screen");
        find(swipeButton).click();
    }

    public void goToDragScreen() {
        Logs.info("Navigate to drag screen");
        find(dragButton).click();
    }
}

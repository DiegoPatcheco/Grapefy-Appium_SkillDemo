package pages;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.ContextManager;
import utilities.Gestures;
import utilities.Logs;

public class WebViewPage extends BasePage {
    private final By robotImage = By.xpath("//h1[@class='hero__title']");
    private final By subtitleLabel = By.className("hero__subtitle");
    private final By getStartedButton = AppiumBy.accessibilityId("Get Started");
    private final By whyWdIOButton = AppiumBy.accessibilityId("Why WebdriverIO?");
    private final By gitHubViewButton = AppiumBy.accessibilityId("View on GitHub");
    private final By youTubeWatchButton = AppiumBy.accessibilityId("Watch on YouTube");
    private final By canvas = AppiumBy.androidUIAutomator("className(\"android.webkit.WebView\").instance(0)");

    @Override
    public void waitPageToLoad() {
        waitPage(AppiumBy.androidUIAutomator(
                        "text(\"WebdriverIO\")"),
                this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Switch to web view context");
        ContextManager.switchWebViewContext();

        Logs.info("Verify web view page elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(waitForDisplayed(robotImage).isDisplayed()),
                () -> Assertions.assertTrue(find(subtitleLabel).isDisplayed())
        );

        Logs.info("Switch to native app context");
        ContextManager.switchNativeAppContext();

        Logs.info("Perform a swipe up");
        Gestures.verticalSwipe(50, 80, 30, find(canvas));

        Logs.info("Verify web view page elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(waitForDisplayed(getStartedButton, 10).isDisplayed()),
                () -> Assertions.assertTrue(find(whyWdIOButton).isDisplayed()),
                () -> Assertions.assertTrue(find(gitHubViewButton).isDisplayed()),
                () -> Assertions.assertTrue(find(youTubeWatchButton).isDisplayed())
        );
    }
}

package pages;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class HomePage extends BasePage {
    private final By robotImage = AppiumBy.androidUIAutomator("description(\"Home-screen\").childSelector(className(android.widget.ImageView).instance(0))");
    private final By appTitleLabel = AppiumBy.androidUIAutomator("text(\"WEBDRIVER\")");
    private final By appDescriptionLabel = AppiumBy.androidUIAutomator("text(\"Demo app for the appium-boilerplate\")");
    private final By supportLabel = AppiumBy.androidUIAutomator("text(\"Support\")");

    @Override
    public void waitPageToLoad() {
        waitPage(robotImage, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verify home page elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(robotImage).isDisplayed()),
                () -> Assertions.assertTrue(find(appTitleLabel).isDisplayed()),
                () -> Assertions.assertTrue(find(appDescriptionLabel).isDisplayed()),
                () -> Assertions.assertTrue(find(supportLabel).isDisplayed())
        );
    }
}

package pages;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Gestures;
import utilities.Logs;

public class FormsPage extends BasePage {
    private final String randomText = new Faker().animal().name();
    private final By textInput = AppiumBy.accessibilityId("text-input");
    private final By inputResult = AppiumBy.accessibilityId("input-text-result");
    private final By formSwitch = AppiumBy.accessibilityId("switch");
    private final By switchText = AppiumBy.accessibilityId("switch-text");
    private final By formDropDown = AppiumBy.androidUIAutomator("resourceId(\"text_input\")");
    private final By dropDownOptions = AppiumBy.androidUIAutomator("className(\"android.widget.CheckedTextView\")");
    private final By activeButton = AppiumBy.accessibilityId("button-Active");
    private final By inActiveButton = AppiumBy.accessibilityId("button-Inactive");
    private final By activeModalTitle = AppiumBy.id("android:id/alertTitle");
    private final By activeModalSubtitle = AppiumBy.id("android:id/message");
    private final By activeModalOkButton = AppiumBy.id("android:id/button1");
    private final By activeModalCancelButton = AppiumBy.id("android:id/button2");

    @Override
    public void waitPageToLoad() {
        waitPage(textInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verify forms page elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(textInput).isDisplayed()),
                () -> Assertions.assertTrue(find(inputResult).isDisplayed()),
                () -> Assertions.assertTrue(find(formSwitch).isDisplayed()),
                () -> Assertions.assertTrue(find(formDropDown).isDisplayed()),
                () -> Assertions.assertTrue(find(activeButton).isDisplayed()),
                () -> Assertions.assertTrue(find(inActiveButton).isDisplayed())
        );
    }

    public void verifyActiveModal() {
        Logs.info("Tap on active button");
        Gestures.tap(find(activeButton));

        Logs.info("Verify button's active modal elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(activeModalTitle).isDisplayed()),
                () -> Assertions.assertTrue(find(activeModalSubtitle).isDisplayed()),
                () -> Assertions.assertTrue(find(activeModalOkButton).isDisplayed()),
                () -> Assertions.assertTrue(find(activeModalCancelButton).isDisplayed())
        );
    }

    public void interactFormElements() {
        Logs.info("Enter random text into text input");
        find(textInput).sendKeys(randomText);

        Logs.info("Tap on switch element");
        Gestures.tap(find(formSwitch));

        Logs.info("Tap on dropdown element & then on its third option");
        Gestures.tap(find(formDropDown));
        waitForDisplayed(dropDownOptions);
        Gestures.tap(findAll(dropDownOptions).get(3));
    }

    public void verifyFormElementsInteraction(String optionText) {
        Logs.info("Verify form elements after interaction");
        Assertions.assertAll(
                () -> Assertions.assertEquals(randomText, find(inputResult).getText()),
                () -> Assertions.assertEquals(getSwitchElementState(formSwitch), find(switchText).getText()),
                () -> Assertions.assertEquals(optionText, find(formDropDown).getText())
        );
    }

    private String getSwitchElementState(By locator) {
        final var state = Boolean.parseBoolean(find(locator).getDomAttribute("checked"));

        if (state) {
            return "Click to turn the switch OFF";
        } else {
            return "Click to turn the switch ON";
        }
    }
}

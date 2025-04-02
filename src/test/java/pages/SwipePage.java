package pages;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Gestures;
import utilities.Logs;

public class SwipePage extends BasePage {
    private final By titleSwipeLabel = AppiumBy.androidUIAutomator("text(\"Swipe horizontal\")");
    private final By subtitleSwipeLabel = AppiumBy.androidUIAutomator("text(\"Or swipe vertical to find what I'm hiding.\")");
    private final By verticalCanvas = AppiumBy.accessibilityId("Swipe-screen");
    private final By horizontalCanvas = AppiumBy.accessibilityId("Carousel");
    private final By robotImage = AppiumBy.accessibilityId("WebdriverIO logo");
    private final By robotLabel = AppiumBy.androidUIAutomator("new UiSelector().text(\"You found me!!!\")");
    private final String carouselItem = "resourceId(\"__CAROUSEL_ITEM_%d_READY__\").childSelector(text(\"%s\"))";

    @Override
    public void waitPageToLoad() {
        waitPage(titleSwipeLabel, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verify swipe page elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(titleSwipeLabel).isDisplayed()),
                () -> Assertions.assertTrue(find(subtitleSwipeLabel).isDisplayed()),
                () -> Assertions.assertTrue(find(verticalCanvas).isDisplayed()),
                () -> Assertions.assertTrue(find(horizontalCanvas).isDisplayed())
        );
    }

    public void doLeftSwipe(int swipes) {
        for (var i = 0; i < swipes; i++) {
            Logs.info("Perform left swipe");
            Gestures.horizontalSwipe(50, 90, 20, find(horizontalCanvas));
        }
    }

    public void doUpSwipe(int swipes) {
        for (var i = 0; i < swipes; i++) {
            Logs.info("Perform left swipe");
            Gestures.verticalSwipe(50, 99, 40, find(verticalCanvas));
        }
    }

    public void verifyCarouselItem(int itemNumber) {
        Logs.info("Verify carousel item elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(getCarouselItemTitleLocator(itemNumber)).isDisplayed())
        );
    }

    public void verifyRobotElements() {
        Logs.info("Verify robot elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(robotImage).isDisplayed()),
                () -> Assertions.assertTrue(find(robotLabel).isDisplayed())
        );
    }

    private By getCarouselItemTitleLocator(int itemNumber) {
        return switch (itemNumber) {
            case 0 -> AppiumBy.androidUIAutomator(String.format(carouselItem, itemNumber, "FULLY OPEN SOURCE"));
            case 1 -> AppiumBy.androidUIAutomator(String.format(carouselItem, itemNumber, "GREAT COMMUNITY"));
            case 2 -> AppiumBy.androidUIAutomator(String.format(carouselItem, itemNumber, "JS.FOUNDATION"));
            case 3 -> AppiumBy.androidUIAutomator(String.format(carouselItem, itemNumber, "SUPPORT VIDEOS"));
            case 4 -> AppiumBy.androidUIAutomator(String.format(carouselItem, itemNumber, "EXTENDABLE"));
            case 5 -> AppiumBy.androidUIAutomator(String.format(carouselItem, itemNumber, "COMPATIBLE"));
            default -> throw new IllegalStateException("Unexpected value: " + itemNumber);
        };
    }
}

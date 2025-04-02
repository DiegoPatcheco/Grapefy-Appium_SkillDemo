package pages;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Gestures;
import utilities.Logs;

import java.util.ArrayList;

public class DragPage extends BasePage {
    private final By titleDragLabel = AppiumBy.androidUIAutomator("text(\"Drag and Drop\")");
    private final By refreshButton = AppiumBy.accessibilityId("renew");
    private final By congratsTitle = AppiumBy.androidUIAutomator("text(\"Congratulations\")");
    private final By congratsLabel = AppiumBy.androidUIAutomator("text(\"You made it, click retry if you want to try it again.\")");
    private final By congratsRetryButton = AppiumBy.accessibilityId("button-Retry");
    private final By[] dragItemArray = new By[]{
            AppiumBy.accessibilityId("drag-l1"),
            AppiumBy.accessibilityId("drag-c1"),
            AppiumBy.accessibilityId("drag-r1"),
            AppiumBy.accessibilityId("drag-l2"),
            AppiumBy.accessibilityId("drag-c2"),
            AppiumBy.accessibilityId("drag-r2"),
            AppiumBy.accessibilityId("drag-l3"),
            AppiumBy.accessibilityId("drag-c3"),
            AppiumBy.accessibilityId("drag-r3")
    };
    private final By[] dropContainerArray = new By[]{
            AppiumBy.accessibilityId("drop-l1"),
            AppiumBy.accessibilityId("drop-c1"),
            AppiumBy.accessibilityId("drop-r1"),
            AppiumBy.accessibilityId("drop-l2"),
            AppiumBy.accessibilityId("drop-c2"),
            AppiumBy.accessibilityId("drop-r2"),
            AppiumBy.accessibilityId("drop-l3"),
            AppiumBy.accessibilityId("drop-c3"),
            AppiumBy.accessibilityId("drop-r3")
    };

    @Override
    public void waitPageToLoad() {
        waitPage(titleDragLabel, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verify drag page elements");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(titleDragLabel).isDisplayed()),
                () -> Assertions.assertTrue(find(dragItemArray[0]).isDisplayed()),
                () -> Assertions.assertTrue(find(dragItemArray[1]).isDisplayed()),
                () -> Assertions.assertTrue(find(dragItemArray[2]).isDisplayed()),
                () -> Assertions.assertTrue(find(dragItemArray[3]).isDisplayed()),
                () -> Assertions.assertTrue(find(dragItemArray[4]).isDisplayed()),
                () -> Assertions.assertTrue(find(dragItemArray[5]).isDisplayed()),
                () -> Assertions.assertTrue(find(dragItemArray[6]).isDisplayed()),
                () -> Assertions.assertTrue(find(dragItemArray[7]).isDisplayed()),
                () -> Assertions.assertTrue(find(dragItemArray[8]).isDisplayed()),
                () -> Assertions.assertTrue(find(dropContainerArray[0]).isDisplayed()),
                () -> Assertions.assertTrue(find(dropContainerArray[1]).isDisplayed()),
                () -> Assertions.assertTrue(find(dropContainerArray[2]).isDisplayed()),
                () -> Assertions.assertTrue(find(dropContainerArray[3]).isDisplayed()),
                () -> Assertions.assertTrue(find(dropContainerArray[4]).isDisplayed()),
                () -> Assertions.assertTrue(find(dropContainerArray[5]).isDisplayed()),
                () -> Assertions.assertTrue(find(dropContainerArray[6]).isDisplayed()),
                () -> Assertions.assertTrue(find(dropContainerArray[7]).isDisplayed()),
                () -> Assertions.assertTrue(find(dropContainerArray[8]).isDisplayed()),
                () -> Assertions.assertTrue(find(refreshButton).isDisplayed())
        );
    }

    public void buildPuzzle() {
        final var itemList = getList(dragItemArray);
        final var containerList = getList(dropContainerArray);
        final var n = itemList.size();

        for (var i = 0; i < n; i++) {
            Gestures.dragTo(find(itemList.get(i)), find(containerList.get(i)));
        }
    }

    public void verifyCongratulationsScreen() {
        Logs.info("Verify congratulations screen");
        Assertions.assertAll(
                () -> Assertions.assertTrue(waitForDisplayed(congratsTitle).isDisplayed()),
                () -> Assertions.assertTrue(find(congratsLabel).isDisplayed()),
                () -> Assertions.assertTrue(find(congratsRetryButton).isDisplayed())
        );
    }

    private static ArrayList<By> getList(By[] array) {
        final var n = array.length;
        final var list = new ArrayList<By>();

        for (var i = 0; i < n; i++) {
            list.add(array[i]);
        }

        return list;
    }
}

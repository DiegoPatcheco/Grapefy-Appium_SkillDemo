package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SwipePage;
import utilities.CommonFlows;

public class SwipeStepDefinition {
    private final CommonFlows commonFlows = new CommonFlows();
    private final SwipePage swipePage = new SwipePage();

    @Given("The user navigates to the Swipe screen")
    public void navigateSwipeScreen() {
        commonFlows.goToSwipePage();
    }

    @When("The user verifies the Swipe screen elements")
    public void verifySwipeScreenElements() {
        swipePage.verifyPage();
    }

    @When("The user performs {int} left swipes")
    public void performsLeftSwipe(int swipes) {
        swipePage.doLeftSwipe(swipes);
    }

    @Then("The user verifies the {int} carousel item elements")
    public void verifyCarouselItemElements(int item) {
        swipePage.verifyCarouselItem(item);
    }

    @When("The user performs {int} up swipes")
    public void performsUpSwipe(int swipes) {
        swipePage.doUpSwipe(swipes);
    }

    @Then("The user verifies the robot elements")
    public void verifyRobotElements() {
        swipePage.verifyRobotElements();
    }
}

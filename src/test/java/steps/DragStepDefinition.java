package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DragPage;
import utilities.CommonFlows;

public class DragStepDefinition {
    private final CommonFlows commonFlows = new CommonFlows();
    private final DragPage dragPage = new DragPage();

    @Given("The user navigates to the Drag screen")
    public void navigateDragScreen() {
        commonFlows.goToDragPage();
    }

    @When("The user verifies the Drag screen elements")
    public void verifyDragScreenElements() {
        dragPage.verifyPage();
    }

    @When("The user builds the image puzzle")
    public void buildImagePuzzle() {
        dragPage.buildPuzzle();
    }

    @Then("The user verifies the congratulations screen")
    public void verifyCongratulationsScreen() {
        dragPage.verifyCongratulationsScreen();
    }
}

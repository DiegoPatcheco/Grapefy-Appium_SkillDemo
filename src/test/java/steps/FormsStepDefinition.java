package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FormsPage;
import utilities.CommonFlows;

public class FormsStepDefinition {
    private final CommonFlows commonFlows = new CommonFlows();
    private final FormsPage formsPage = new FormsPage();

    @Given("The user navigates to the Forms screen")
    public void navigateFormsScreen() {
        commonFlows.goToFormsPage();
    }

    @When("The user verifies the Forms screen elements")
    public void verifyFormsScreenElements() {
        formsPage.verifyPage();
    }

    @When("The user verifies the Forms active modal elements")
    public void verifyFormsActiveModalElements() {
        formsPage.verifyActiveModal();
    }

    @When("The user interact with the Form elements")
    public void interactWithFormElements() {
        formsPage.interactFormElements();
    }

    @Then("The user verifies the result after interaction")
    public void verifyResultAfterInteraction() {
        formsPage.verifyFormElementsInteraction("This app is awesome");
    }
}

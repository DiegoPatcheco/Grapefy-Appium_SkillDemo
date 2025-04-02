package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BottomBar;
import pages.HomePage;
import utilities.CommonFlows;

public class HomeStepDefinition {
    private final CommonFlows commonFlows = new CommonFlows();
    private final HomePage homePage = new HomePage();
    private final BottomBar bottomBar = new BottomBar();

    @Given("The user navigates to the Home screen")
    public void navigateHomeScreen() {
        commonFlows.goToHomePage();
    }

    @Then("The user verifies the Home screen elements")
    public void verifyHomeScreenElements() {
        homePage.verifyPage();
    }

    @Then("The user verifies the Bottom bar elements")
    public void verifyBottomBarElements() {
        bottomBar.verifyPage();
    }
}

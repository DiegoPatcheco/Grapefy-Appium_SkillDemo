package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.WebViewPage;
import utilities.CommonFlows;

public class WebViewStepDefinition {
    private final CommonFlows commonFlows = new CommonFlows();
    private final WebViewPage webViewPage = new WebViewPage();

    @Given("The user navigates to the WebView screen")
    public void navigateWebViewScreen() {
        commonFlows.goToWebViewPage();
    }

    @When("The user verifies the WebView screen elements")
    public void verifyWebViewScreenElements() {
        webViewPage.verifyPage();
    }
}

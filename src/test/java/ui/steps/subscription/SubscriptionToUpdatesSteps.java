package ui.steps.subscription;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.pages.HomePage.HomePage;
import ui.utils.ConfigReader;
import ui.utils.DriverHelper;

public class SubscriptionToUpdatesSteps {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);


    @When("user scrolls down to footer")
    public void user_scrolls_down_to_footer() {
        homePage.scrollToFooter();
    }
    @Then("user verifies {string} title")
    public void user_verifies_title(String expectedTitle) {
        homePage.validateSubscriptionTitle(expectedTitle);
    }
    @When("user enters email address {string} to Subscription form")
    public void user_enters_email_address_to_subscription_form(String userEmail) {
        homePage.enterSubscribeDetails(ConfigReader.readProperty(userEmail));
    }
    @When("user clicks arrow button")
    public void user_clicks_arrow_button() {
        homePage.clickSubscribeButton();
    }

    @Then("user verifies subscription success message {string} is visible")
    public void user_verifies_subscription_success_message_is_visible(String expectedMessage) {
        homePage.validateSuccessfulSubscribeMessage(expectedMessage);
    }
}

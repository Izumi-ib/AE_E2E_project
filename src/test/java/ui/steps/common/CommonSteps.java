package ui.steps.common;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.actions.common.CommonActions;
import ui.pages.HomePage.HomePage;
import ui.pages.common.CommonUIElements;
import ui.utils.DriverHelper;

public class CommonSteps {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    CommonActions commonActions = new CommonActions(driver);

    @Given("user clicks consent button verifies home page is visible")
    public void user_clicks_consent_button_verifies_home_page_is_visible() {
        homePage.clickConsentButton();
        homePage.validateHomePage(driver.getCurrentUrl());
    }

    @Then("user verifies that the top title in the Home page {string} is displayed")
    public void user_verifies_that_the_top_title_in_the_home_page_is_displayed(String expectedTitle) {
        homePage.validateTopCarouselTitles(expectedTitle);
    }

    @When("user scrolls up to Page top")
    public void user_scrolls_up_to_page_top() {
        commonActions.scrollUp();
    }

    @When("user clicks Upward Arrow button")
    public void user_clicks_upward_arrow_button() {
        commonActions.clickArrowScrollUpButton();
    }
}

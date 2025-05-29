package ui.steps.common;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.actions.HomePage.HomePageActions;
import ui.actions.common.CommonActions;
import ui.utils.DriverHelper;


public class CommonSteps {

    private WebDriver driver;
    private HomePageActions homePageActions;
    private CommonActions commonActions;

    @Before
    public void init(){
        driver = DriverHelper.getDriver();
        commonActions = new CommonActions(driver);
        homePageActions = new HomePageActions(driver);
    }

    @Given("user clicks consent button verifies home page is visible")
    public void user_clicks_consent_button_verifies_home_page_is_visible() {
        homePageActions.clickConsentButton();
        homePageActions.validateHomePage(driver.getCurrentUrl());
    }

    @Then("user verifies that the top title in the Home page {string} is displayed")
    public void user_verifies_that_the_top_title_in_the_home_page_is_displayed(String expectedTitle) {
        homePageActions.validateTopCarouselTitles(expectedTitle);
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

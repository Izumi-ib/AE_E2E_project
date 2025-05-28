package ui.steps.common;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.pages.HomePage.HomePage;
import ui.pages.commonMethods.ScrollMethods;
import ui.utils.DriverHelper;

public class ScrollUpSteps {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ScrollMethods scrollMethods = new ScrollMethods(driver);

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
        scrollMethods.scrollUp();
    }

    @When("user clicks Upward Arrow button")
    public void user_clicks_upward_arrow_button() {
        scrollMethods.clickArrowScrollUpButton();
    }
}

package ui.actions.HomePage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.HomePage.HomePage;
import ui.utils.BrowserUtils;

import java.time.Duration;

public class HomePageActions {
    private final WebDriver driver;
    private final Actions actions;
    private final WebDriverWait wait;
    private final HomePage homePage;

    public HomePageActions(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
        this.homePage = new HomePage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickConsentButton() {
        homePage.consentButton.click();
    }

    public void validateHomePage(String actualUrl) {
        if (homePage.homePageButton.isDisplayed()) Assertions.assertEquals(actualUrl, "https://automationexercise.com/");
    }

    public void clickSignAndLoginButton() {
        homePage.signUpAndLoginButton.click();
    }

    public void validateLoggedInTitle(String expectedMessage) {
        Assertions.assertTrue(homePage.loggedInAsTitle.getText().trim().contains(expectedMessage));
    }

    public void deleteAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.deleteAccountButton)).click();
    }

    public void clickHomeButton() {
        homePage.homePageButton.click();
    }

    public void clickLogoutButton() {
        homePage.logoutButton.click();
    }

    public void clickContactUsButton() {
        homePage.contactUsPageButton.click();
    }

    public void clickTestCasesPageButton() {
        homePage.testCasesPageButton.click();
    }

    public void clickProductsPageButton() {
        homePage.productsPageButton.click();
    }

    public void clickCartPageButton() {
        homePage.cartPageButton.click();
    }

    public void scrollToFooter() {
        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.subscriptionTitle).perform();
    }

    public void validateSubscriptionTitle(String expectedTitle) {
        Assertions.assertTrue(homePage.subscriptionTitle.isDisplayed() && homePage.subscriptionTitle.getText().equals(expectedTitle));
    }

    public void enterSubscribeDetails(String email) {
        homePage.subscriptionEmailInput.sendKeys(email);
    }

    public void clickSubscribeButton() {
        homePage.subscribeButton.submit();
    }

    public void validateSuccessfulSubscribeMessage(String expectedMessage) {
        if (homePage.successfullySubscribedAlert.isDisplayed())
            Assertions.assertTrue(homePage.successfullySubscribedAlert.getText().equals(expectedMessage));
    }

    public void scrollDownAndValidateRecommendedItemsTitle(String expectedTitle) {
        BrowserUtils.scrollIntoView(driver, homePage.recommendedItemsSectionHeader);

        Assertions.assertEquals(expectedTitle, homePage.recommendedItemsSectionHeader.getText().trim());
    }

    public void hoverAndAddRecommendedProduct(String productsId) {
        actions.clickAndHold(homePage.recommendedCarousel).perform();

        while (true) {
            try {
//                WebElement itemAddToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='recommended-item-carousel']//div[@class='single-products']//a[@data-product-id='" + productsId + "']")));
                WebElement itemAddToCartButton = driver.findElement(By.xpath("//div[@id='recommended-item-carousel']//div[@class='single-products']//a[@data-product-id='" + productsId + "']"));
                if (itemAddToCartButton.isDisplayed() && itemAddToCartButton.isDisplayed()) {
                    itemAddToCartButton.click();
                    break;
                } else {
                    homePage.recommendedNextButton.click();
                }
            } catch (TimeoutException e) {
                System.out.println("Product " + productsId + " not found yet, waiting for carousel update...");
            }
        }
    }

    public void validateTopCarouselTitles(String expectedTitle) {

        boolean isTitleHere = false;
        for (WebElement title : homePage.topCarouselTitles) {
            if (title.isDisplayed() && title.getText().contains(expectedTitle)) {
                isTitleHere = true;
                break;
            }
        }
        Assertions.assertTrue(isTitleHere, "Title is not there or not visible");
    }


}

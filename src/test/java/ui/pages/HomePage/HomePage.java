package ui.pages.HomePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utils.BrowserUtils;
import ui.utils.DriverHelper;


import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver = DriverHelper.getDriver();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[.='Consent']")
    WebElement consentButton;
    @FindBy(xpath = "//a[@href='/login']")
    WebElement signUpAndLoginButton;
    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    WebElement homePageButton;
    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    WebElement loggedInAsTitle;
    @FindBy(xpath = "//a[contains(text(), 'Delete Account')]")
    WebElement deleteAccountButton;
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    WebElement logoutButton;
    @FindBy(xpath = "//a[contains(text(), 'Contact')]")
    WebElement contactUsPageButton;
    @FindBy(xpath = "//a[contains(text(), 'Test Cases')]")
    WebElement testCasesPageButton;
    @FindBy(xpath = "//a[contains(text(), 'Products')]")
    WebElement productsPageButton;
    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    WebElement cartPageButton;
    @FindBy(xpath = "//h2[contains(text(), 'Subscription')]")
    WebElement subscriptionTitle;
    @FindBy(id = "susbscribe_email")
    WebElement subscriptionEmailInput;
    @FindBy(id = "subscribe")
    WebElement subscribeButton;
    @FindBy(css = "#success-subscribe div")
    WebElement successfullySubscribedAlert;
    @FindBy(xpath = "//div[@class='recommended_items']/h2")
    WebElement recommendedItemsSectionHeader;
    @FindBy(id = "recommended-item-carousel")
    WebElement recommendedCarousel;
    @FindBy(xpath = "//div[@id='recommended-item-carousel']//a[@data-slide='next']")
    WebElement recommendedNextButton;
    @FindBy(xpath = "//div[@id='slider-carousel']//div[@class='carousel-inner']//h2")
    List<WebElement> topCarouselTitles;

    public void clickConsentButton() {
        consentButton.click();
    }

    public void validateHomePage(String actualUrl) {
        if (homePageButton.isDisplayed()) Assert.assertEquals(actualUrl, "https://automationexercise.com/");
    }

    public void clickSignAndLoginButton() {
        signUpAndLoginButton.click();
    }

    public void validateLoggedInTitle(String expectedMessage) {
        Assert.assertTrue(loggedInAsTitle.getText().trim().contains(expectedMessage));
    }

    public void deleteAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccountButton)).click();
    }

    public void clickHomeButton() {
        homePageButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void clickContactUsButton() {
        contactUsPageButton.click();
    }

    public void clickTestCasesPageButton() {
        testCasesPageButton.click();
    }

    public void clickProductsPageButton() {
        productsPageButton.click();
    }

    public void clickCartPageButton() {
        cartPageButton.click();
    }

    public void scrollToFooter() {
        Actions actions = new Actions(driver);
        actions.moveToElement(subscriptionTitle).perform();
    }

    public void validateSubscriptionTitle(String expectedTitle) {
        Assert.assertTrue(subscriptionTitle.isDisplayed() && subscriptionTitle.getText().equals(expectedTitle));
    }

    public void enterSubscribeDetails(String email) {
        subscriptionEmailInput.sendKeys(email);
    }

    public void clickSubscribeButton() {
        subscribeButton.submit();
    }

    public void validateSuccessfulSubscribeMessage(String expectedMessage) {
        if (successfullySubscribedAlert.isDisplayed())
            Assert.assertTrue(successfullySubscribedAlert.getText().equals(expectedMessage));
    }

    public void scrollDownAndValidateRecommendedItemsTitle(String expectedTitle) {
        BrowserUtils.scrollIntoView(driver, recommendedItemsSectionHeader);

        Assert.assertEquals(expectedTitle, recommendedItemsSectionHeader.getText().trim());
    }

    public void hoverAndAddRecommendedProduct(String productsId) {
        actions.clickAndHold(recommendedCarousel).perform();

        while (true) {
            try {
//                WebElement itemAddToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='recommended-item-carousel']//div[@class='single-products']//a[@data-product-id='" + productsId + "']")));
                WebElement itemAddToCartButton = driver.findElement(By.xpath("//div[@id='recommended-item-carousel']//div[@class='single-products']//a[@data-product-id='" + productsId + "']"));
                if (itemAddToCartButton.isDisplayed() && itemAddToCartButton.isDisplayed()) {
                    itemAddToCartButton.click();
                    break;
                } else {
                    recommendedNextButton.click();
                }
            } catch (TimeoutException e) {
                System.out.println("Product " + productsId + " not found yet, waiting for carousel update...");
            }
        }
    }

    public void validateTopCarouselTitles(String expectedTitle) {

        boolean isTitleHere = false;
        for (WebElement title : topCarouselTitles) {
            if (title.isDisplayed() && title.getText().contains(expectedTitle)) {
                isTitleHere = true;
                break;
            }
        }
        Assert.assertTrue("Title is not there or not visible", isTitleHere);
    }


}

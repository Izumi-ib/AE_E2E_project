package ui.pages.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Consent']")
    public WebElement consentButton;
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpAndLoginButton;
    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    public WebElement homePageButton;
    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    public WebElement loggedInAsTitle;
    @FindBy(xpath = "//a[contains(text(), 'Delete Account')]")
    public WebElement deleteAccountButton;
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    public WebElement logoutButton;
    @FindBy(xpath = "//a[contains(text(), 'Contact')]")
    public WebElement contactUsPageButton;
    @FindBy(xpath = "//a[contains(text(), 'Test Cases')]")
    public WebElement testCasesPageButton;
    @FindBy(xpath = "//a[contains(text(), 'Products')]")
    public WebElement productsPageButton;
    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    public WebElement cartPageButton;
    @FindBy(xpath = "//h2[contains(text(), 'Subscription')]")
    public WebElement subscriptionTitle;
    @FindBy(id = "susbscribe_email")
    public WebElement subscriptionEmailInput;
    @FindBy(id = "subscribe")
    public WebElement subscribeButton;
    @FindBy(css = "#success-subscribe div")
    public WebElement successfullySubscribedAlert;
    @FindBy(xpath = "//div[@class='recommended_items']/h2")
    public WebElement recommendedItemsSectionHeader;
    @FindBy(id = "recommended-item-carousel")
    public WebElement recommendedCarousel;
    @FindBy(xpath = "//div[@id='recommended-item-carousel']//a[@data-slide='next']")
    public WebElement recommendedNextButton;
    @FindBy(xpath = "//div[@id='slider-carousel']//div[@class='carousel-inner']//h2")
    public List<WebElement> topCarouselTitles;




}

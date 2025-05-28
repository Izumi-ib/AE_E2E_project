package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHelper;

import java.time.Duration;
import java.util.List;

public class CommonMethods {
    WebDriver driver = DriverHelper.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);

    public CommonMethods(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "scrollUp")
    WebElement scrollUpArrowButton;
    @FindBy(xpath = "//img[contains(@alt, 'Website')]")
    WebElement automationTopLogo;

    public void clickArrowScrollUpButton(){
        wait.until(ExpectedConditions.elementToBeClickable(scrollUpArrowButton)).click();
    }
    public void scrollUp(){
        actions.moveToElement(automationTopLogo).perform();
    }

    public void validateFormSubmitErrorAlert(String expectedMessage){
        List<WebElement> inputs = driver.findElements(By.cssSelector("input"));

        for (WebElement input : inputs) {
            Boolean isValid = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].checkValidity();", input);

            if (!isValid) {
                String message = (String) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].validationMessage;", input);

                Assert.assertEquals(expectedMessage, message);
            }
        }
    }

}

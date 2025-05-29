package ui.actions.common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.common.CommonUIElements;
import ui.utils.DriverHelper;

import java.time.Duration;
import java.util.List;

public class CommonActions {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    private final CommonUIElements commonUIElements;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        this.commonUIElements = new CommonUIElements(driver);
    }

    public void clickArrowScrollUpButton(){
        wait.until(ExpectedConditions.elementToBeClickable(commonUIElements.scrollUpArrowButton)).click();
    }
    public void scrollUp(){
        actions.moveToElement(commonUIElements.automationTopLogo).perform();
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

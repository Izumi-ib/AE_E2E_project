package ui.pages.common;

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
import ui.utils.DriverHelper;

import java.time.Duration;
import java.util.List;

public class CommonUIElements {

    public CommonUIElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "scrollUp")
    public WebElement scrollUpArrowButton;
    @FindBy(xpath = "//img[contains(@alt, 'Website')]")
    public WebElement automationTopLogo;



}

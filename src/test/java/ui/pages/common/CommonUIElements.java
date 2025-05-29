package ui.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonUIElements {

    public CommonUIElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "scrollUp")
    public WebElement scrollUpArrowButton;
    @FindBy(xpath = "//img[contains(@alt, 'Website')]")
    public WebElement automationTopLogo;



}

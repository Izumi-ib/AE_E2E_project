package ui.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import ui.utils.ConfigReader;
import ui.utils.DriverHelper;

public class Hook {

    @Before
    public void setup(){
        WebDriver driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("homePageUrl"));
    }

    @After
    public void tearDown(){
        DriverHelper.quitDriver();
    }

}

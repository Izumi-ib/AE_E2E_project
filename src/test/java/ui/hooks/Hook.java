package ui.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import ui.utils.AllureUtils;
import ui.utils.ConfigReader;
import ui.utils.DriverHelper;

public class Hook {
    private WebDriver driver;
    private AllureUtils allureUtils;

    @Before
    public void setup(){
        driver = DriverHelper.getDriver();
        allureUtils = new AllureUtils(driver);
        driver.get(ConfigReader.readProperty("homePageUrl"));
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            allureUtils.takeScreenshot();
        }
        DriverHelper.quitDriver();
    }

}

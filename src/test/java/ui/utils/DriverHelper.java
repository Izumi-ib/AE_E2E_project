package ui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;



public class DriverHelper {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public DriverHelper(){
    }

    public static WebDriver getDriver() {
        if (driver.get() == null || ((RemoteWebDriver) driver.get()).getSessionId() == null) {
            String browser = ConfigReader.readProperty("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();

                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--headless=new");
//                    options.addArguments("--disable-gpu");
//                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    driver.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get().manage().deleteAllCookies();
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class Driver {
    public static WebDriver driver = null;

    private Driver() {
    }

    public static WebDriver getDriver(){
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(capabilities);
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quit(){
        System.out.println("quitting the browser");
        driver.quit();
        driver = null;
    }

    public static void getMainPage(){
        String url = JsonUtils.url;
        driver.get(url);
    }

    public static WebDriverWait waitVisibility(){
        return new WebDriverWait(driver, Duration.ofSeconds(JsonUtils.wait_visibility));
    }

}

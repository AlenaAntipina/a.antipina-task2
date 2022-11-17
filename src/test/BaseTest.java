package test;

import main.Driver;
import main.JsonUtils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static main.Driver.driver;
import static main.Driver.getMainPage;

public class BaseTest {
    @BeforeClass
    public void setUp() throws IOException, ParseException {
        JsonUtils.readJson();
        Driver.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(JsonUtils.wait_time, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(JsonUtils.load_page_time, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        getMainPage();
    }


    @AfterClass
    public void tearDown(){
        Driver.quit();
    }
}

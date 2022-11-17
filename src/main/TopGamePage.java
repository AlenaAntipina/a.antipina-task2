package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static main.Driver.driver;

public class TopGamePage {

    private static final By GAME_NAME = By.xpath("//div[@id='appHubAppName']");
    private static final By GAME_DATE = By.xpath("//div[@class='release_date']//div[@class='date']");
    private static final By GAME_PRICE = By.xpath("//div[contains(@class,'game_purchase_price')]");

    public TopGamePage(){}
    public boolean isPageOpen() {
        List<WebElement> list = driver.findElements(GAME_NAME);
        return !list.isEmpty();
    }
    public String[] getTopGameInfo(){
        return new String[] { driver.findElement(GAME_NAME).getText(), driver.findElement(GAME_DATE).getText(), driver.findElement(GAME_PRICE).getText() };
    }
}

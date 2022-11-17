package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static main.Driver.driver;
import static main.StringUtils.getNumberFromElement;

public class AboutPage extends BasePage{
    private static final By UNIQUE_ELEM_ON_PAGE = By.xpath("//body[contains(@class,'promoannounce')]");
    private static final By STORE_BUTTON = By.xpath("//*[@class='supernav_container']//a[@data-tooltip-content='.submenu_store']");
    private static final By GAMERS_ONLINE = By.xpath("//*[./*[contains(@class,'gamers_online')]]");
    private static final By GAMERS_NOW = By.xpath("//*[./*[contains(@class,'gamers_in_game')]]");

    public AboutPage(){
    }

    @Override
    public boolean isPageOpen() {
        List<WebElement> list = driver.findElements(UNIQUE_ELEM_ON_PAGE);
        return !list.isEmpty();
    }

    public void clickStore(){
        driver.findElement(STORE_BUTTON).click();
    }

    public boolean isOnlineMoreThanNow(){
        int online = getNumberFromElement(GAMERS_ONLINE);
        int now = getNumberFromElement(GAMERS_NOW);
        return now < online;
    }
}

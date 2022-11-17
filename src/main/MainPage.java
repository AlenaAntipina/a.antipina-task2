package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static main.Driver.*;

public class MainPage extends BasePage{
    private static final By UNIQUE_ELEM_ON_PAGE = By.xpath("//body[contains(@class,'infinite_scrolling')]");
    private static final By ABOUT_BUTTON = By.xpath("//div[@class='supernav_container']/a[contains(@href,'about')]");
    private static final By POPUP = By.xpath("//div[@id='noteworthy_tab' and contains(@class,'focus')]");
    private static final By TOP_SALES = By.xpath("//div[@id='noteworthy_flyout']//a[contains(@href,'topselling')]");

    public MainPage(){
    }

    @Override
    public boolean isPageOpen() {
        List<WebElement> list = driver.findElements(UNIQUE_ELEM_ON_PAGE);
        return !list.isEmpty();
    }

    public void clickAbout(){
        driver.findElement(ABOUT_BUTTON).click();
    }

    public void clickNew(){
        waitVisibility().until(ExpectedConditions.visibilityOfElementLocated(POPUP));
        driver.findElement(TOP_SALES).click();
    }

}

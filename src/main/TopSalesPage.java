package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static main.Driver.driver;
import static main.Driver.waitVisibility;

public class TopSalesPage {
    private static final By UNIQUE_ELEM_ON_PAGE = By.xpath("//h1[contains(.,'Лидеры продаж')]");
    private static final By BTN_MORE = By.xpath("//button[contains(@class,'DialogButton')]");

    public TopSalesPage(){}

    public boolean isPageOpen() {
        List<WebElement> list = driver.findElements(UNIQUE_ELEM_ON_PAGE);
        return !list.isEmpty();
    }

    public void selectMore(){
        waitVisibility().until(ExpectedConditions.visibilityOfElementLocated(BTN_MORE));
        driver.findElement(BTN_MORE).click();
    }
}

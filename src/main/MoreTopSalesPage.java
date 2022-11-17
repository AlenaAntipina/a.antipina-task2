package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static main.Driver.driver;
import static main.Driver.waitVisibility;

public class MoreTopSalesPage {
    private static final By UNIQUE_ELEM_ON_PAGE = By.xpath("//*[contains(@class,'pageheader')]");
    private static final By CHECK_LINUX = By.xpath("//*[contains(@data-value,'linux')]//span[contains(@class,'checked')]");
    private static final By CHECK_COOPERATIV = By.xpath("//*[@data-value='48']//span[contains(@class,'checked')]");
    private static final By CHECK_ACTION = By.xpath("//*[@data-value='19']//span[contains(@class,'checked')]");
    private static final By ACTION_LABELS = By.xpath("//*[@data-value='19']//span[contains(@class,'count')]");
    private static final By ACTION_RESULT = By.xpath("//div[@id='search_results_filtered_warning_persistent']/div");
    private static final By INPUT_ACTION_BUTTON = By.xpath("//input[@id='TagSuggest']");
    private static final By NAME = By.xpath("//div[@id='search_resultsRows']/a[1]//*[@class='title']");
    private static final By DATE = By.xpath("//div[@id='search_resultsRows']/a[1]//*[contains(@class,'search_released')]");
    private static final By PRICE = By.xpath("//div[@id='search_resultsRows']/a[1]//*[contains(@class,'search_price')]//div[contains(@class,'search_price')]");

    public MoreTopSalesPage(){
    }

    public boolean isPageOpen() {
        List<WebElement> list = driver.findElements(UNIQUE_ELEM_ON_PAGE);
        return !list.isEmpty();
    }

    public boolean isSelectLinux(){
        return driver.findElements(CHECK_LINUX) != null;
    }

    public boolean isSelectCooperativ(){
        return driver.findElements(CHECK_COOPERATIV) != null;
    }

    public boolean isSelectAction(){
        return driver.findElements(CHECK_ACTION) != null;
    }

    public void inputAction() {
        driver.findElement(INPUT_ACTION_BUTTON).sendKeys("экшен");
    }

    public int getQuantityLabels(){
        waitVisibility().until(ExpectedConditions.visibilityOfElementLocated(ACTION_LABELS));
        return Integer.parseInt(driver.findElement(ACTION_LABELS).getText().replaceAll("\\s",""));
    }

    public int getResultsRequest() throws InterruptedException {
        Thread thread = new Thread();
        thread.sleep(2000);
        String quantity = driver.findElement(ACTION_RESULT).getText();
        return Integer.parseInt(quantity.substring(quantity.indexOf(":") + 2, quantity.indexOf(".")).replaceAll(",",""));
    }

    public String[] getInfo(){
        return new String[] { driver.findElement(NAME).getText(), driver.findElement(DATE).getText(), driver.findElement(PRICE).getText() };
    }

    public void clickTopGame(){
        driver.findElement(NAME).click();
    }

}

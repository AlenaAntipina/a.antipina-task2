package main;

import org.openqa.selenium.By;

import static main.Driver.driver;

public class StringUtils {
    public StringUtils() {
    }

    public static int getNumberFromElement(By xpath){
        String text = driver.findElement(xpath).getText();
        return Integer.parseInt(text.substring(text.indexOf("\n") + 1).replaceAll(",",""));
    }
}

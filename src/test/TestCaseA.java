package test;

import main.AboutPage;
import main.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static main.Driver.driver;

public class TestCaseA extends BaseTest{
    @Test
    public void aboutPageTest(){
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "The page is not open. \nExpected URL : https://store.steampowered.com/ \nActual URL : " + driver.getCurrentUrl());

        mainPage.clickAbout();
        AboutPage aboutPage = new AboutPage();
        Assert.assertTrue(aboutPage.isPageOpen(), "The page is not open. \nExpected URL : https://store.steampowered.com/about/ \nActual URL : " + driver.getCurrentUrl());

        boolean compare = aboutPage.isOnlineMoreThanNow();
        Assert.assertTrue(compare, "The number of online gamers is no more than the number of players in the game. \nError on https://store.steampowered.com/about/");

        aboutPage.clickStore();
        Assert.assertTrue(mainPage.isPageOpen(), "The page is not open. \nExpected URL : https://store.steampowered.com/ \nActual URL : " + driver.getCurrentUrl());
    }
}

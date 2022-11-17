package test;

import main.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static main.Driver.driver;

public class TestCaseB extends BaseTest{
    @Test
    public void topGameTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "The page is not open. \nExpected URL : https://store.steampowered.com/ \nActual URL : " + driver.getCurrentUrl());

        mainPage.clickNew();
        TopSalesPage topSalesPage = new TopSalesPage();
        Assert.assertTrue(topSalesPage.isPageOpen(), "The page is not open. \nExpected URL : https://store.steampowered.com/charts/topselling/RU \nActual URL : " + driver.getCurrentUrl());

        topSalesPage.selectMore();
        MoreTopSalesPage moreTopSalesPage = new MoreTopSalesPage();
        Assert.assertTrue(moreTopSalesPage.isPageOpen(), "The page is not open. \nExpected URL : https://store.steampowered.com/search/?filter=topsellers \nActual URL : " + driver.getCurrentUrl());

        Assert.assertTrue(moreTopSalesPage.isSelectLinux(), "The checkbox (SteamOS + Linux) is not selected.");

        Assert.assertTrue(moreTopSalesPage.isSelectCooperativ(), "The checkbox (Cooperativ(LAN)) is not selected.");

        moreTopSalesPage.inputAction();
        int quantity = moreTopSalesPage.getQuantityLabels();
        Assert.assertTrue(moreTopSalesPage.isSelectAction(), "The checkbox (Action) is not selected.");
        Assert.assertEquals(moreTopSalesPage.getResultsRequest(), quantity, "The specified number of results for the query not corresponds to the number of games in the list.");

        String[] top_first = moreTopSalesPage.getInfo();

        moreTopSalesPage.clickTopGame();
        TopGamePage topGamePage = new TopGamePage();
        Assert.assertTrue(topGamePage.isPageOpen(), "The page is not open. \nExpected URL : https://store.steampowered.com/app/4000/Garrys_Mod/ \nActual URL : " + driver.getCurrentUrl());

        String[] first_game = topGamePage.getTopGameInfo();
        Assert.assertEquals(top_first[0], first_game[0], "The name of the game does not match the name obtained in the previous step. It's another game.");
        Assert.assertEquals(top_first[1], first_game[1], "The release date of the game does not match the release date obtained in the previous step. It's another game.");
        Assert.assertEquals(top_first[2], first_game[2], "The price of the game does not match the price obtained in the previous step. It's another game.");
    }

}




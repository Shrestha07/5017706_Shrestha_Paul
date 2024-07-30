package test;

import stock.StockMarket;
import stock.MobileApp;
import stock.WebApp;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        MobileApp mobileApp = new MobileApp();
        WebApp webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("Stock price changes:");
        stockMarket.setStockPrice(120.50);
        stockMarket.setStockPrice(125.75);
    }
}
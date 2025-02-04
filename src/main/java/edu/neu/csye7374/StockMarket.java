package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static StockMarket singletonInstance;

    private List<Stock> allStocks = new ArrayList<>();

    private StockMarket()
    {

    }

    public static StockMarket getInstance() {
        if (singletonInstance == null) {
            synchronized (StockMarket.class) {
                if (singletonInstance == null) {
                    singletonInstance = new StockMarket();
                }
            }
        }
        return singletonInstance;
    }

    public void addStock(Stock stockItem)
    {
        allStocks.add(stockItem);
    }

    public boolean removeStock(Stock stock)
    {
        return allStocks.remove(stock);
    }

    public void updatePrice(Stock stock, double newPrice)
    {
        if(allStocks.contains(stock))
        {
            stock.setStockPrice(newPrice);

        }
    }
    public void displayAllStocks()
    {
        allStocks.forEach(stock -> System.out.println(stock.toString()));
    }


}

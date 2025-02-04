package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;



abstract class Stock extends StockAPI implements Tradable {

    public Stock() {
        super();
    }


    public void setMetric(int metric) {
        this.metric = metric;
    }

    private int metric;

    protected List<Double> allBidsPlacedSoFar = new ArrayList<>();

    public Stock (String stockName, double stockPrice, String description)
    {
    	super(stockName, stockPrice, description);
        allBidsPlacedSoFar.add(stockPrice);
    }


    @Override
    public void setBid(double bid) {
    allBidsPlacedSoFar.add(bid);
        double sum = 0;
        for (Double price : allBidsPlacedSoFar) {
            sum += price;
        }
        double newPrice = sum / allBidsPlacedSoFar.size();
        StockMarket.getInstance().updatePrice(this, newPrice);


    }

    private static void initializeAndProcessStock(Stock stock, int[] bids) {
        StockMarket.getInstance().addStock(stock);
        for (int bid : bids) {
            stock.setBid(bid);
            stock.getMetric();
            System.out.println(stock.toString());

        }
    }

    public static void demo()
    {

        System.out.println("======= Tesla Stock Bid Start ======= ");
        Stock tesla = new TeslaStock(80);
        initializeAndProcessStock(tesla, new int[]{90, 100, 141, 145, 150, 155});
        System.out.println("\n");

        System.out.println("======= Nike Stock Bid Start ======= ");
        Stock nike = new NikeStock(90);
        initializeAndProcessStock(nike, new int[]{90, 100, 141, 145, 150, 155});
        System.out.println("\n");


        System.out.println("======= All Stock Information ======= ");
        StockMarket.getInstance().displayAllStocks();
        System.out.println("\n");


    }
}

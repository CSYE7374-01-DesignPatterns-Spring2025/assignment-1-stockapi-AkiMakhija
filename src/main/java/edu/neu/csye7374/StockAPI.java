package edu.neu.csye7374;

public class StockAPI {

    private String stockName;

    private double stockPrice;

    private String description;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StockAPI(String stockName, double stockPrice, String description) {
		super();
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.description = description;
	}

	public StockAPI() {
		super();
	}
	
	
	 @Override
	    public String toString() {
	        StringBuilder stringBuilder = new StringBuilder();
	        stringBuilder.append("Stock name = ").append(stockName)
	                .append(", Stock price = ").append(stockPrice)
	                .append(", Stock description = ").append(description);
	                
	        return stringBuilder.toString();
	    }
	
    
}

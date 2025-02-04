package edu.neu.csye7374;


public class NikeStock extends Stock {

    public NikeStock(double price)
    {
        super("Nike", price, "Retail Pvt Ltd");
    }

    /**
     *
     * @return Stability Over Time metric
     */
    @Override
    public int getMetric() {
        double averageBid = allBidsPlacedSoFar.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        int newMetric = (int) (100 - Math.abs(this.allBidsPlacedSoFar.get(allBidsPlacedSoFar.size()-1) - averageBid));
        setMetric(newMetric);
        return newMetric;
    }
    
	
	 @Override
	    public String toString() {
	        StringBuilder stringBuilder = new StringBuilder();
	        stringBuilder.append("Stock name = ").append(this.getStockName())
	                .append(", Stock price = ").append(this.getStockPrice())
	                .append(", Stock description = ").append(this.getDescription())
	                .append(", Stock Metric = ").append(this.getMetric());
	                
	        return stringBuilder.toString();
	    }
	
}


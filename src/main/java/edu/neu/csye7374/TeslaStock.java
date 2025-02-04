package edu.neu.csye7374;


public class TeslaStock extends Stock {
    public TeslaStock(double price) {
        super("Tesla", price, "Electric Vehicle Company");
    }

    /**
     *
     * @return Demand-Supply Equilibrium with Historical Insight Metric
     */
    @Override
    public int getMetric() {
        double averageBid = allBidsPlacedSoFar.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double ratio = this.allBidsPlacedSoFar.get(allBidsPlacedSoFar.size()-1) / averageBid;
        int newMetric =  (ratio > 1.2) ? 2 : (ratio < 0.8) ? -2 : 0;
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


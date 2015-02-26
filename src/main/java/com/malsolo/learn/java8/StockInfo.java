package com.malsolo.learn.java8;

public class StockInfo {
	
	public final String ticker;
	public final double price;
	
	public StockInfo(String ticker, double price) {
		super();
		this.ticker = ticker;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("ticker: %s price: %g", ticker, price);
	}
	
	public static void main(String[] args) {
		System.out.println(new StockInfo("TICKER", 1.0));
	}

}

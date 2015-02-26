package com.malsolo.learn.java8;

import java.util.function.Predicate;

public class StockUtil {

	public static StockInfo getPrice(String ticker) {
		return new StockInfo(ticker, YahooFinance.getPrice(ticker, false));
	}
	
	public static Predicate<StockInfo> isPriceLessThan(final double price) {
		return stockInfo -> stockInfo.price < price;
	}
	
	public static StockInfo pickHigh(final StockInfo stockInfo1, final StockInfo stockInfo2) {
		return stockInfo1.price > stockInfo2.price ? stockInfo1 : stockInfo2;
	}

}

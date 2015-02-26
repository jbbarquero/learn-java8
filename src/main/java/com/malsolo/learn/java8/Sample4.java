package com.malsolo.learn.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Get me the highest stock price less than $500 from symbols
 * https://www.youtube.com/watch?v=j9nj5dTo54Q
 * Java 8 Language Capabilities, What's in it for you?
 * 
 * http://www.agiledeveloper.com/downloads.html
 * 
 * http://www.agiledeveloper.com/presentations/java8_lambdas_the_path_way_to_functional_style.zip
 * 
 * https://twitter.com/venkat_s
 * 
 * 
 *
 */
public class Sample4 {
	
	public static StockInfo dummy = new StockInfo("", 0.0);
	
	public static void main(String[] args) {
		System.out.println(">>>>> IMPERATIVE...");
		Timeit.code(() -> findImperative(Tickers.symbols));
		System.out.println(">>>>> FUNCTIONAL...");
		Timeit.code(() -> findFunctional(Tickers.symbols.stream()));
		System.out.println(">>>>> FUNCTIONAL PARALLEL...");
		Timeit.code(() -> findFunctional(Tickers.symbols.parallelStream()));
		System.out.println("<<<<< DONE.");
	}
	
	public static void findImperative(List<String> symbols) {
		List<StockInfo> stocks = new ArrayList<>();
		for (String symbol : symbols) {
			stocks.add(StockUtil.getPrice(symbol));
		}
		
		List<StockInfo> stocksLessThan500 = new ArrayList<>();
		for (StockInfo stock : stocks) {
			if (StockUtil.isPriceLessThan(500).test(stock)) {
				stocksLessThan500.add(stock);
			}
		}
		
		StockInfo highPriced = dummy;
		for (StockInfo stock : stocksLessThan500) {
			highPriced = StockUtil.pickHigh(highPriced, stock);
		}
		
		System.out.println(highPriced);
		
	}

	public static void findFunctional(Stream<String> symbols) {
		System.out.println(
			symbols.map(StockUtil::getPrice)
			.filter(StockUtil.isPriceLessThan(500))
			.reduce(dummy, StockUtil::pickHigh)
		);
	}
	

}

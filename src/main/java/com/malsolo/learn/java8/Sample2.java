package com.malsolo.learn.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Strategy pattern
 */
public class Sample2 {
	
	public static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
		return numbers.stream().filter(selector).reduce(0, (a, b) -> a + b);
	}
	
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		System.out.println(totalValues(values, e -> true));
		System.out.println(totalValues(values, e -> e % 2 == 0));
		System.out.println(totalValues(values, e -> e % 2 != 0));
	}

}

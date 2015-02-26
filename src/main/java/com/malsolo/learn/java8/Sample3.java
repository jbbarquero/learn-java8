package com.malsolo.learn.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * The double of the first even number greater than 3 in the list 
 *
 */
public class Sample3 {
	
	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
		//values = Arrays.asList(1, 3, 5, 7, 9);
		
		long start = System.nanoTime();
		int result = 0;
		for (int e : values) {
			if (e > 3 && e % 2 == 0) {
				result = e * 2;
				break;
			}
		}
		long end = System.nanoTime() - start;
		System.out.println(result);
		System.out.printf("For took %.1f us%n", end / 1000.0);
		
		start = System.nanoTime();
		System.out.println(
				values.stream()
					.filter(e -> e > 3)
					.filter(e -> e % 2 == 0)
					.map(e -> e * 2)
					.findFirst()
					.orElse(0)
				);
		end = System.nanoTime() - start;
		System.out.printf("Stream took %.1f us%n", end / 1000.0);
		
		start = System.nanoTime();
		Stream<Integer> stream = values.stream()
		.filter(Sample3::isGT3)
		.filter(Sample3::isEven)
		.map(Sample3::doubleIt);
		end = System.nanoTime() - start;
		System.out.printf("Stream calculation took %.1f us%n", end / 1000.0);
		start = System.nanoTime();
		System.out.println(
				stream
					.findFirst()
					.orElse(0)
				);
		end = System.nanoTime() - start;
		System.out.printf("Stream execution took %.1f us%n", end / 1000.0);
	}
	
	public static boolean isEven(int number) {
		System.out.println("isEven for " + number);
		return number % 2 == 0;
	}

	public static boolean isGT3(int number) {
		System.out.println("isGT3 for " + number);
		return number > 3;
	}

	public static int doubleIt(int number) {
		System.out.println("doubleIt for " + number);
		return number * 2;
	}
}

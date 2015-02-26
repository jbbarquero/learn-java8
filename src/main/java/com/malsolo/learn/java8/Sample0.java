package com.malsolo.learn.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Sample0 {
	
	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		System.out.println("Iterate with an array");
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i));
		}
		
		System.out.println("Iterate with a foreach");
		for (Integer integer : values) {
			System.out.println(integer);
		}
		
		System.out.println("Iterate with an inner forEach and a Consumer (anonymous inner class)");
		values.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		});
		
		System.out.println("Iterate with an inner forEach and a Consumer (anonymous function)");
		values.forEach((Integer i) -> System.out.println(i));

		System.out.println("Iterate with an inner forEach and a Consumer (anonymous function and Java is now smart)");
		values.forEach(i -> System.out.println(i));

		System.out.println("Iterate with an inner forEach and a Consumer (function reference)");
		values.forEach(System.out::println);
		
		System.out.println("Now lets sum");
		int total = 0;
		for (Integer integer : values) {
			total += integer * 2;
		}
		System.out.println(total);
		
		System.out.println("Now lets sum, iterating with a stram, and transforming with a map function");
		System.out.println(values.stream().map(e -> e * 2).reduce(0, (i, e) -> i + e)); 
		
	}

}

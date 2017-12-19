package com.ny.util;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalUtil {
	
	public static <T> T timed(String description, Supplier<T> supplier) {
		
		Consumer<String> consumer = System.out::println;
		return timed(description, supplier, consumer);
		
	}
	
	public static <T> T timed(String description, Supplier<T> supplier, Consumer<String> consumer) {
		
		LocalTime startTime = LocalTime.now();
		final T t = supplier.get();
		LocalTime endTime = LocalTime.now();
		consumer.accept("Time taken to complete " + description + ": " + ChronoUnit.NANOS.between(startTime, endTime));
		return t;
	}
	
	
}

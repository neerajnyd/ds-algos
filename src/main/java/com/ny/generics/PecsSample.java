package com.ny.generics;

import java.util.Arrays;
import java.util.List;

class Fruit{}
class Banana extends Fruit{}
class Orange extends Fruit{}

public class PecsSample {

    public static <T> void copy(List<? extends T> producer, List<? super T> consumer) {
        consumer.addAll(producer);
    }

    public static void main(String[] args) {

        List<Fruit> fruits = Arrays.asList(new Fruit(), new Fruit(), new Fruit());
        List<Banana> bananas = Arrays.asList(new Banana(), new Banana());
        List<Orange> oranges = Arrays.asList(new Orange(), new Orange(), new Orange(), new Orange());

        copy(bananas, fruits);

    }

}

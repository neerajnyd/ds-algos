package com.ny.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
interface Predicate<Resources> {
    boolean test(Resources resources);
}

@FunctionalInterface
interface Consumer<Resources> {
    void accept(Resources resources);
}

class Resource {
    private final int rollNumber;
    private final int age;
    private final String name;

    Resource(int rollNumber, int age, String name) {
        this.rollNumber = rollNumber;
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "rollNumber=" + rollNumber +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Java8Example {
    public static void main(String[] args) {
        List<Resource> seperateList = new ArrayList<>();//Seperate list will be fill from original list
        Consumer<Resource> consumer = System.out::println;
        Consumer<Resource> seperateListConsumer = seperateList::add;

        Predicate<Resource> nameStartsWithS = resource -> resource.getName().startsWith("S");
        Predicate<Resource> truePredicate = resource -> true;
        Predicate<Resource> falsePredicate = resource -> false;
        List<Resource> resourceList = Arrays.asList(new Resource(1, 32, "Saurabh"),
                new Resource(2, 30, "Neeraj"), new Resource(3, 34, "Rahul"));
        System.out.println("Unsorted List with Predicate Testing ");
        displayList(resourceList, truePredicate, consumer);
        resourceList.sort(Comparator.comparing(Resource::getName));
        System.out.println("Sorted List with Predicate Testing ");
        displayList(resourceList, truePredicate, consumer);
        System.out.println("Name starts with S Predicate Testing ");
        displayList(resourceList, nameStartsWithS, seperateListConsumer);
        System.out.println("false Predicate Testing ");
        displayList(resourceList, falsePredicate, consumer);
        displayList(seperateList, truePredicate, consumer);
    }

    private static void displayList(List<Resource> resourceList, Predicate<Resource> condition, Consumer<Resource> consumer) {
        for (Resource resource : resourceList) {
            if (condition.test(resource)) {
                consumer.accept(resource);
            }
        }
    }
}





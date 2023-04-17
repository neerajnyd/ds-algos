package com.ny.klarna;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Smoothie {

    @Test
    public void shouldThrowExceptionIfEmptyOrder() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Smoothie.ingredients(""),
                "Invalid order. Order cannot be empty.");
    }

    @Test
    public void classicSmoothie() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry",
                Smoothie.ingredients("Classic"));
    }

    @Test
    public void classicSmoothieWithoutStrawberry() {
        assertEquals("banana,honey,mango,peach,pineapple",
                Smoothie.ingredients("Classic,-strawberry"));
    }

    @Test
    public void classicSmoothieWithInvalidExcludeIngredient() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry",
                Smoothie.ingredients("Classic,-avocado"));
    }

    @Test
    public void shouldThrowExceptionIfInvalidSmoothie() {
        String name = "Classic2";
        assertThrows(
                IllegalArgumentException.class,
                () -> Smoothie.ingredients(name),
                "Invalid order. " + name + " is not a valid smoothie name at Functional Smoothies Inc.");
    }

    @Test
    public void classicSmoothieWithMango() {
        String name = "Classic";
        String ingredients = name + ",mango";
        String expectedErrorMsg = "Invalid order. Adding additional ingredients is currently unsupported at Functional Smoothies Inc.";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Smoothie.ingredients(ingredients));
        Assertions.assertEquals(expectedErrorMsg, exception.getMessage());
    }

    @Test
    public void shouldReturnIngredientsWithValidAndInvalidExcludeIngredient() {
        String name = "Classic";
        String ingredients = name + ",-blackberry,-blueberry,-honey";
        String actual = Smoothie.ingredients(ingredients);
        assertEquals("banana,mango,peach,pineapple,strawberry", actual);
    }

    private final static Map<String, Set<String>> SMOOTHIES = Map.of(
            "Classic", Set.of("banana", "honey", "mango", "peach", "pineapple", "strawberry"),
            "Freezie", Set.of("black currant", "blackberry", "blueberry", "frozen yogurt", "grape juice"),
            "Greenie", Set.of("apple juice", "avocado", "green apple", "ice", "lime", "spinach"),
            "Just Desserts", Set.of("banana", "cherry", "chocolate", "ice cream", "peanut")
    );

    /**
     * @param order - comma separated list of smoothie name and then ingredients to exclude or include
     * @return the ingredients that the smoothie should include
     * throws IllegalArgumentException if the ordered smoothie isn't made with the ingredients that are part of the order
     */
    public static String ingredients(String order) {

        final String[] ingredients = getIngredients(order);

        final ValidationResponse validationResponse = validateOrder(ingredients);

        if (validationResponse.isFailure()) {
            throw new IllegalArgumentException("Invalid order. " + validationResponse.getErrorMessage());
        }

        Set<String> excludeIngredients = Arrays.stream(ingredients, 1, ingredients.length)
                .filter(s -> s.startsWith("-"))
                .map(s -> s.substring(1))
                .collect(Collectors.toSet());

        String smoothieName = ingredients[0];
        return SMOOTHIES.get(smoothieName).stream()
                .filter(s -> !excludeIngredients.contains(s))
                .sorted()
                .collect(Collectors.joining(","));
    }

    private static String[] getIngredients(String order) {
        return order == null || order.isEmpty() ? new String[]{} : order.split(",");
    }

    private static ValidationResponse validateOrder(String[] ingredients) {

        if (ingredients.length == 0) {
            return ValidationResponse.failure("Order cannot be empty.");
        }

        String smoothieName = ingredients[0]; //making an assumption here that the first word is always the name of the smoothie

        if (!SMOOTHIES.containsKey(smoothieName)) {
            return ValidationResponse.failure(smoothieName + " is not a valid smoothie name at Functional Smoothies Inc.");
        }

        if (ingredients.length == 1) {
            return ValidationResponse.success();
        }

        boolean additionalIngredients = Arrays.stream(ingredients, 1, ingredients.length)
                .anyMatch(s -> !s.startsWith("-"));
        if (additionalIngredients) {
            return ValidationResponse.failure(
                    "Adding additional ingredients is currently unsupported at Functional Smoothies Inc."
            );
        }
        return ValidationResponse.success();
    }


    private static class ValidationResponse {
        private boolean success;
        private String errorMessage;

        public static ValidationResponse success() {
            ValidationResponse response = new ValidationResponse();
            response.success = true;
            return response;
        }

        public static ValidationResponse failure(String errorMessage) {
            ValidationResponse response = new ValidationResponse();
            response.success = false;
            response.errorMessage = errorMessage;
            return response;
        }

        /*public boolean isSuccess() {
            return success;
        }*/

        public boolean isFailure() {
            return !success;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    public static void main(String[] args) {

        System.out.println(ingredients("Freezie,blackberry,avocado,-cherry,mango"));

    }


}



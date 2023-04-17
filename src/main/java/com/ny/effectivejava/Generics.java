package com.ny.effectivejava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generics {


    static class Chooser<T> {
        private final List<T> choiceArray;

        public Chooser(Collection<T> choices) {
            choiceArray = new ArrayList<>(choices);
        }

        public Object choose() {
            Random rnd = ThreadLocalRandom.current();
//            choiceArray[rnd.nextInt(choiceArray.length)];
            return new Object();
        }
    }

}

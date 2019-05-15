package com.epam.training.testable;

import java.util.Arrays;
import java.util.Comparator;

public class Sorter {

    public void sort(Integer[] numbers) {
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 < i2 ? -1 : (i2 > i1 ? 1 : 0);
            }
        });
    }
}

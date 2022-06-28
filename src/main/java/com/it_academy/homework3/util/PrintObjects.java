package com.it_academy.homework3.util;

import java.util.List;

public final class PrintObjects {

    private PrintObjects() {
    }

    /**
     * Print objects to the console
     *
     * @param list List of objects
     * @param <E> Any object
     */
    public static <E> void printObjects(List<E> list) {
        list.forEach(System.out::println);
    }
}

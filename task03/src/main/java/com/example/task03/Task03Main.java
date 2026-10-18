package com.example.task03;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
import java.util.List;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        if (stream == null || order == null || minMaxConsumer == null){
            throw new NullPointerException();
        }

        List<? extends T> list = stream.toList();

        if (list.isEmpty()){
            minMaxConsumer.accept(null, null);
            return;
        }

        T min = Collections.min(list, order);
        T max = Collections.max(list, order);

        minMaxConsumer.accept(min, max);
    }
}

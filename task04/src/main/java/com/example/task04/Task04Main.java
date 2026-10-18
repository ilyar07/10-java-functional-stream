package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;

public class Task04Main {

    public static void main(String[] args) {

        new BufferedReader( new InputStreamReader(System.in, StandardCharsets.UTF_8))
                .lines()
                .flatMap(line -> Arrays.stream(line.split("[^a-zA-Zа-яА-ЯёЁ0-9]+")))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(word -> System.out.print(word + "\n"));
    }

}

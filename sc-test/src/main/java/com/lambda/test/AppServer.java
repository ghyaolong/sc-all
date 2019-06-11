package com.lambda.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppServer {

    private List<Apple> appleStore = new ArrayList<>();

    public List<Apple> getAppleBy(Predicate<Apple> predicate){
        /*ArrayList result = new ArrayList();
        for (Apple apple : appleStore) {
            if (predicate.test(apple)){
                result.add(apple);
            }
        }*/
        return appleStore.stream().filter(predicate).collect(Collectors.toList());
        //return result;
    }

    public static void main(String[] args) {
        AppServer appServer = new AppServer();
        appServer.getAppleBy(a->a.getColor().equals("red"));
    }
}

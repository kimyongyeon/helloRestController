package com.hello.hellorestcontroller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@SpringBootApplication
@MapperScan(basePackages = "com.hello.hellorestcontroller.mapper")
public class HellorestcontrollerApplication {

    public static class Apple {

        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }

        public static boolean isGreenApple(Apple apple) {
            return "green".equals(apple.getColor());
        }

    }

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );
        filterApples(inventory, Apple::isGreenApple);
        // 조건을 다이나믹하게 보낼 수 있다.
        filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "red".equals(a.getColor()));

        SpringApplication.run(HellorestcontrollerApplication.class, args);
    }

    static void setLike(Apple apple, Predicate<Apple> p) {
        if (p.test(apple)) {

        } else {

        }
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

}

package com.zw.test;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Test1 {

    @Test
    public void test01() {
        BiFunction<Integer, Integer, String> biFunction = (x, y) -> x + ":" + y;
        String apply = biFunction.apply(1, 2);
        System.out.println(apply);
    }

    @Test
    public void test02() {
        BiFunction<Integer, Integer, String> biFunction = (x, y) -> x + ":" + y;
        UnaryOperator<String> up = str -> "键值对为:" + str;
        String apply = biFunction.andThen(up).apply(3, 5);
        System.out.println(apply);
    }

    @Test
    public void test03() {
        BiFunction<Integer, Integer, Integer> biFun = (x, y) -> x + y;
        Function<Integer, String> up = n -> "结果为:" + n;
        String apply = biFun.andThen(up).apply(3, 5);
        System.out.println(apply);
    }

    @Test
    public void test04() {
        BinaryOperator<Integer> biOp = (x, y) -> x * y;
        Integer apply = biOp.apply(3, 5);
        System.out.println(apply);
    }

    @Test
    public void test05() {
        Student s1 = new Student("张三", 23);
        Student s2 = new Student("李四", 34);
        StudentComparator studentComparator = new StudentComparator();
        Student applyMin = BinaryOperator.minBy(studentComparator).apply(s1, s2);
        Student applyMax = BinaryOperator.maxBy(studentComparator).apply(s1, s2);

        System.out.println(applyMin);
        System.out.println(applyMax);
    }
}

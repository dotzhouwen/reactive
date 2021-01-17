package com.zw.test;

import org.junit.Test;
import java.util.function.*;

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

    @Test
    public void test06() {
        Consumer<String> con = str -> System.out.println("hello:" + str);
        con.accept("Tom");
    }

    @Test
    public void test07() {
        Consumer<Integer> con = n -> System.out.println(n * 2);
        Consumer<Integer> con2 = n -> System.out.println(n * n);
        con.andThen(con2).accept(5);
    }

    @Test
    public void test08() {
        Supplier<String> sup = () -> "Lambda";
        System.out.println(sup.get());
    }

    @Test
    public void test09() {
        Function<Integer, String> function = n -> "I love " + n;
        String apply = function.apply(20);
        System.out.println(apply);
    }

    @Test
    public void test10() {
        Function<Integer, Integer> fun1 = x -> x * 2;
        Function<Integer, Integer> fun2 = x -> x * x;
        Integer apply = fun1.andThen(fun2).apply(3);
        System.out.println(apply);

        Integer apply1 = fun1.compose(fun2).apply(3);
        System.out.println(apply1);
    }

    @Test
    public void test11() {
        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(3));
    }

    @Test
    public void test12() {
        UnaryOperator<Integer> unaryOperator = x -> x * 2;
        Integer apply = unaryOperator.apply(10);
        System.out.println(apply);
    }


}

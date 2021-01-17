package com.zw.test;

import org.junit.Test;

import java.util.function.*;

public class MethodTest {

    @Test
    public void test01() {
        Consumer<Integer> sleeping = Person::sleeping;
        sleeping.accept(20);
    }

    @Test
    public void test02() {
        Person p = new Person("张三");
        Function<Integer, String> function = p::play;
        String apply = function.apply(20);
        System.out.println(apply);
    }

    @Test
    public void test03() {
        BiFunction<Person, Integer, String> biFunction = Person::play;
        Person p = new Person("刘备");
        String apply = biFunction.apply(p, 20);
        System.out.println(apply);
    }

    @Test
    public void test04() {
        BiConsumer<Person, String> study = Person::study;
        study.accept(new Person("张飞"), "Lambda");
    }

    @Test
    public void test05() {
        Supplier<Person> supplier = Person::new;
        Person person = supplier.get();
        System.out.println(person);
    }

    @Test
    public void test06() {
        Function<String, Person> function = Person::new;
        Person person = function.apply("张飞");
        System.out.println(person);
    }
}

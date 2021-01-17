package com.zw.test;

public class Person {
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public static void sleeping(int hours) {
        System.out.println("sleeping:" + hours + "小时");
    }

    public String play(int minute) {
        return name + "已经玩了" + minute + "分钟了";
    }

    public void study(String course) {
        System.out.println(name + "正在学习:" + course);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

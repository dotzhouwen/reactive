package com.zw.test;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class ReactorTest {

    @Test
    public void test01() {
        Flux<Integer> just = Flux.just(1, 2, 3, 4);
        just.subscribe(System.out::println);
    }
}

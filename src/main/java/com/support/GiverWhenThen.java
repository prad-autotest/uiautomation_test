package com.support;

import java.util.function.Consumer;

public class GiverWhenThen {
    public static void Given(Consumer<String> consumer) {
        consumer.accept("Given");
    }
    public static void Then(Consumer<String> consumer) {
        consumer.accept("Then");
    }
    public static void When(Consumer<String> consumer) {
        consumer.accept("When");
    }
    public static void And(Consumer<String> consumer) {
        consumer.accept("And");
    }

}

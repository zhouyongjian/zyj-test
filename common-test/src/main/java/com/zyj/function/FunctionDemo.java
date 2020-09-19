package com.zyj.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式编程练习
 *
 */
public class FunctionDemo {
    public static void main(String[] args) {
        /**
         * 供给型接口
         */
        Supplier<String> supplier = () ->{ return "supplier"; };
        System.out.println(supplier.get());

        /**
         * 判定型接口
         */
        Predicate<Integer> predicate = integer -> { return integer > 0; };
        System.out.println(predicate.test(1));

        /**
         * 函数型接口
         */
        Function<String,Double> function = s -> { return Double.valueOf(s); };
        System.out.println(function.apply("123.44"));

        /**
         * 消费型接口
         */
        Consumer<Boolean> consumer =  aBoolean -> { System.out.println(aBoolean); };
        consumer.accept(true);
    }
}


package com.zyj.stream;
import com.zyj.lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream 流式编程
 */
public class StreamDemo {
    public static void main(String[] args) {
        Book b1 = new Book(11,"a",  23);
        Book b2 = new Book(12,"b",  24);
        Book b3 = new Book(13,"c",  22);
        Book b4 = new Book(14,"d",  28);
        Book b5 = new Book(16,"e",  26);
        List<Book> books = Arrays.asList(b1, b2, b3,b4,b5);
        // list -> map
       books.stream().collect(Collectors.toMap(Book::getBookName, book -> book));


        List<Integer> collect = books.stream().map(book -> {
            return book.getId()*2;
        }).collect(Collectors.toList());
        System.out.println(collect);

        books.stream().filter( book -> {return book.getId()%2 == 0;}) // 过滤id是偶数
                .filter( book -> {return book.getPrice() > 24;}) // 过滤价格 > 24
                .map(book -> { return book.getBookName().toUpperCase();})// 返回书名字大写
                .sorted((s1, s2)->{ return  s2.compareTo(s1);}) // 自定义排序
                .limit(1) // 返回一个
                .forEach(System.out::println); // sout遍历

    }




}

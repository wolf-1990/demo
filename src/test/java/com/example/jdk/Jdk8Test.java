package com.example.jdk;

import com.jklc.model.Region;
import org.junit.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Jdk8Test {
    @Test
    public void  aa(){
        new Thread(()->System.out.println("你好，jdk8")).start();
      /*  (params)-> expression;
        (params)->statement;
        (params)->{statements};*/
//      (int envn,int odd)->even+odd
    }
    public void bb(){
        JButton show = new JButton("Show");
        show.addActionListener((e)->{System.out.print("怕怕了啊，我的jdk8");});
    }
    @Test
    public void cc(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time");
        features.forEach(n->System.out.println(n+"哈哈"));
    }
    @Test
    public void dd(){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
//        filter(languages, (str)->str.s);
    }
    public static void filter(List<String> names, Predicate condition) {
//        for(String name: names)  {
////            if(condition.test(name)) {
////                System.out.println(name + " ");
////            }
////        }
        names.stream().filter((name)->
                (condition.test(name))).forEach((name)->{System.out.print(name+" ");});
    }

    public static void main(String[] args) {
//        String str = new String("www.runoob.com");
//        System.out.println(str.startsWith("www") );

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//        filter(languages,(str)-> );
//        filter(languages,(a)->);
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost)->(cost + 0.12 * cost)+" ").forEach(System.out::print);
        System.out.println();
        double bill = costBeforeTax.stream().map((cost)->(cost + 0.12*cost)).reduce((sum,cost)->sum+cost).get();
        System.out.print(bill);
    }
    @Test
    public void ee(){
        List<String> strList = Arrays.asList("Java", "Scala", "C", "Haskell", "Lisp");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }
    @Test
    public void ff(){
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String aa = G7.stream().map(x->x.toUpperCase()).collect(Collectors.joining(","));
        System.out.print(aa);
    }
    @Test
    public void gg(){
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i->i).distinct().collect(Collectors.toList());
        System.out.print(distinct);
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n",
                numbers, distinct);
    }
    @Test
    public void hh(){
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics intSummaryStatistics = primes.stream().mapToInt((x) -> x).summaryStatistics();
        long sum = intSummaryStatistics.getSum();
        double average = intSummaryStatistics.getAverage();
        long count = intSummaryStatistics.getCount();
        System.out.printf("sum :%s ,avg:%s ,count:%s %n",sum,average,count);
    }
}

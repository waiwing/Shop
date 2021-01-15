package com.waiwing.Shop.Optional;

import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import javax.validation.constraints.Null;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {
    @Test
    public void test() {
//        Optional<Integer> empty = Optional.empty();
//        empty.get();
//
//        Optional<Integer> numberAble = Optional.empty();
//        Integer value = numberAble.get();
//
//        System.out.println(value);
//        numberAble.ifPresent(a -> System.out.println(a));
//        Integer a =    numberAble.orElse(2);
//        System.out.println(a);
//        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
//        Arrays.sort(array, new Comparator() {
//            @Override
//            public int compare(Object o, Object t1) {
//                return 0;
//            }
//
//            @Override
//            public boolean equals(Object o) {
//                return false;
//            }
//        });

        Person person = new Person();
        Student student = new Student();
//        person.fuck(t-> t+1);
        person.fuck(Student::GoFuck);
        System.out.println(person.count);
    }
}
class Person{
  int count = 0;
  public void fuck(Girl student){
      count += student.GoFuck2(12);
  }
}
class Student implements  Girl{

    @Override
    public   int GoFuck2(int fuck){
        return  10000+fuck;
    }

    public static int GoFuck(int fuck){
        return  10000+fuck;
    }


}

interface Girl{
    public int GoFuck2(int fuck);
}

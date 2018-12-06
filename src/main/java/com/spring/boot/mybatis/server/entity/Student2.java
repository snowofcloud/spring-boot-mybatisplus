package com.spring.boot.mybatis.server.entity;

import java.util.Arrays;

/**
 * @auther xuxq
 * @date 2018/12/6 21:50
 */
public class Student2 {
    //不定参数的使用
    public static void method(int... numbers){
        Arrays.asList(numbers).forEach(number -> System.out.println(number));
    }

    public static void methods(int[] numberss){
        Arrays.asList(numberss).forEach(number -> System.out.println(number));
    }

    public static void main(String[] args) {
        Student2.method(1,2,3);
        System.out.println("==========================================");
        Student2.method(1,2,3,4,5);
        System.out.println("==========================0");
        Student2.methods(new int[] {10,20,30,40});
    }

}

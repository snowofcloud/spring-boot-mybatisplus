package com.spring.boot.mybatis.server.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @auther xuxq
 * @date 2018/12/6 21:33
 */
public class Student {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("a","长城");
        map.put("b","长江");
        map.put("c","长征");
        //第一种 forEach遍历
        for (String key:map.keySet()){
            System.out.println(map.get(key));
        }
        System.out.println("==============================================================");
        //迭代器遍历
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey()+"-------"+entry.getValue());
        }
        System.out.println("==============================================================");
        //entrySet
        for (Map.Entry<String, String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+"-------"+entry.getValue());
        }
        System.out.println("==============================================================");
        //lambda进行遍历
        map.forEach((key,value)-> System.out.println(key+"----"+value));

    }
}

package com.spring.boot.mybatis.server.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @auther xuxq
 * @date 2018/12/30 11:33
 */
public class DateTime {
    //java中的六大日期时间类及部分JDK1.8中time包下日期时间新特性
    public static void main(String[] args) throws Exception {
        //java中六个日期时间类的使用及区别
        //1----->>java.util.Date;  日期格式为：年月日时分秒
        //2----->>java.text.SimpleDateFormat;其他五种均可以被格式化同种样式的时间
        //3----->>java.util.Calendar;日历类Calendar类是一个抽象基类，主要用于日期之间的各种计算获取Calendar实例的方法：使用Calendar.getInstance()方法或调用它子类GregorianCalendar的构造器。
        //4----->>java.sql.Date;日期格式为：年月日
        //5----->>java.sql.Time;日期格式为：时分秒
        //6----->>java.sql.Timestamp;日期格式为：年月日时分秒纳秒（毫微秒）

        //java.util.Date 是java.sql.Date,java.sql.Time,java.sql.Timestamp的父类
        //1.java.util.Date 就是在除了SQL语句的情况下面使用
        //2.java.sql.Date 是针对SQL语句使用的，new java.sql.Date(new java.util.Date().getTime()，它只包含日期而没有时间部分
        //3.它都有getTime方法返回毫秒数
        //4.互相转换
            //new java.sql.Date(new java.util.Date().getTime())
            //new java.util.Date(new java.sql.Date(0).getTime())

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        //java.util.Date和java.text.SimpleDateFormat
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyyMMdd-HH/mm/ss");
        Date date = new Date();//获取当前日期时间

        //java1.8中time包下：获取现在的日期时间，也可以of自定义日期时间等；
        LocalDate nowDate = LocalDate.now();//java.time.LocalDate;包下，日期类 //里面提供了很多方法：如获取第几天、第几月、早晚、日期加减等；
        LocalTime nowTime = LocalTime.now();//java.time.LocalTime;包下，时间类,并且提供了毫秒//里面提供了很多方法：如获取哪一秒、哪一分钟、早晚等；
        LocalDateTime nowDateTime = LocalDateTime.now();//java.time.LocalDateTime;包下，日期时间类，

        String format1 = sdf1.format(date);            //输出结果：2018-12-30
        Date date1 = sdf1.parse("2018-12-30");//输出结果：Sun Dec 30 00:00:00 CST 2018
        String format2 = sdf2.format(date);           //输出结果：20181230
        Date date2 = sdf2.parse("20181230");//输出结果：Sun Dec 30 00:00:00 CST 2018
        String format3 = sdf3.format(date);         //输出结果：2018/12/30
        Date date3 = sdf3.parse("2018/12/30");//输出结果：Sun Dec 30 00:00:00 CST 2018
        String format4 = sdf4.format(date);           //输出结果：2018-12-30 12:25:37
        Date date4 = sdf4.parse("2018-12-30 12:03:45");//输出结果：Sun Dec 30 12:03:45 CST 2018


        System.out.println(date); //Sun Dec 30 12:03:45 CST 2018
        System.out.println("============================================");
        System.out.println(format1);
        System.out.println(date1);
        System.out.println(format2);
        System.out.println(date2);
        System.out.println(format3);
        System.out.println(date3);
        System.out.println(format4);
        System.out.println(date4);
        System.out.println("============================================");
        System.out.println(sb1.append(nowDate).append(nowTime));//2018-12-3012:25:37.755
        System.out.println(sb2.append(nowDateTime));//2018-12-30T12:25:37.755


        //java.util.Calendar
        Date date5 = sdf4.parse("2018-12-30 12:03:45");
        Calendar instance = Calendar.getInstance();
        instance.setTime(date5);
        instance.add(Calendar.DATE,1);
        Date date6 =instance.getTime();
        System.out.println("------------------------------------------");
        System.out.println(date6);


        //java.util.Date 是java.sql.Date,java.sql.Time,java.sql.Timestamp的父类
        //java.sql.Date 是针对SQL语句使用的，new java.sql.Date(new java.util.Date().getTime()，它只包含日期而没有时间部分
        java.sql.Date date7 = new java.sql.Date(14454635);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("sql.Date:" + date7);
        System.out.println("sql.Date:" + date7.getTime());//它都有getTime方法返回毫秒数
        //互相转换
            //new java.sql.Date(new java.util.Date().getTime())
            //new java.util.Date(new java.sql.Date(0).getTime())
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(new java.util.Date(new java.sql.Date(10).getTime()));
        System.out.println(new java.sql.Date(new java.util.Date().getTime()));
        //java.sql.Timestamp的使用
        Date date8 = new Date();//java.util.Date包下
        Timestamp timestamp = new Timestamp(date8.getTime());//java.sql.Timestamp;包下
        System.out.println("666666666666666666666666666666666666666666666666666666666666666");
        System.out.println(timestamp);

    }
}

package com.spring.boot.mybatis.server.entity;

import java.util.concurrent.Callable;

/**
 * @auther xuxq
 * @date 2018/12/17 23:19
 */
public class Threadd implements Callable<Integer> {
    //线程启动的三种方式
    int i=0;
    public Integer call() throws Exception {
        for (; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+""+i);
        }
        return i;
    }

}

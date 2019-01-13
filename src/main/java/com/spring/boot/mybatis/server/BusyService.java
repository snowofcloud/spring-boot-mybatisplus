package com.spring.boot.mybatis.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @auther xuxq
 * @date 2019/1/6 18:04
 */
@Service //@Service标识着它会被Spring初始化为一个实例
@Slf4j   //而@Slf4j则标识着我们可以直接使用log打印日志。
public class BusyService {

    @Async
    public CompletableFuture<String> busyMethod(String name) throws InterruptedException {
        log.info(name);
        String s = "Hello," + name + "!";
        Thread.sleep(5000);//使用线程休眠模拟那些耗时的服务
        return CompletableFuture.completedFuture(s);
    }
    //busyMethod方法，它的返回值是CompletableFuture，CompletableFuture继承自Future，
    // 它可以把多个异步执行的结果合并到一个单独的异步结果中，CompletableFuture是任何异步服务所需要的。

    //注解@Async，它标识着这个方法是异步方法，调用它时是异步调用的。


}

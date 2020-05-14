package com.alibaba.nacos.example.task;


import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerTaskServiceDemo {

    private static ScheduledExecutorService scheduledExecutorService = Executors
        .newScheduledThreadPool(10, new ThreadFactory() {
            AtomicInteger count = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                t.setName("com.alibaba.nacos.server.Timer-" + count.getAndIncrement());
                return t;
            }
        });

    static public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,
                                              TimeUnit unit) {
        scheduledExecutorService.scheduleWithFixedDelay(command, initialDelay, delay, unit);
    }


    public static void main(String[] args) throws Exception{

        Runnable runnable = ()->{
            System.out.println("execute: time = "+new Date());
        };

        System.out.println("startTime = "+new Date());

        // 启动之后5s开始执行 以后每隔10s执行1次
        TimerTaskServiceDemo.scheduleWithFixedDelay(runnable,5,10,TimeUnit.SECONDS);


        TimeUnit.MINUTES.sleep(100);

    }

}

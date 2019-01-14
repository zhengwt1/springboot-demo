package com.example.demo6.Scheduled;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 张攀钦
 * @date 2018/12/21-18:27
 * 测试 定时任务
 * @Scheduled的使用可以总结如下几种方式：
 * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
 * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
 * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
 * @Scheduled(cron="") ：通过cron表达式定义规则
 */
@Component
public class ScheduledTasks {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Scheduled(fixedRate = 5000)
    @Async
    public void reportCurrentTime() {
       System.out.println("现在时间：" + DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }

    @Async
    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTime1() {
       System.out.println("现在时间：" + DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }

    @Async
    @Scheduled(initialDelay=1000, fixedRate=5000)
    public void reportCurrentTime2(){
       System.out.println("现在时间：" + DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }
    @Async
    @Scheduled(cron="0 * * * * ?")
    public void reportCurrentTime3(){
        System.out.println("现在时间：" + DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }
}
package com.example.demo6.Scheduled;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.common.util.concurrent.UncaughtExceptionHandlers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.Task;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * @author 张攀钦
 * @date 2018-12-21-18:26
 */
@Configuration
@EnableScheduling
@Slf4j
public class SchedulingConfig implements SchedulingConfigurer {
    /**
     * @author 张攀钦
     * @date 2019/1/2-21:28
     * 核心线程数
     */
    
    private static final Integer SCHEDULING_CORE_POOL_SIZE =15;

    /**
     * @author 张攀钦
     * @date 2019/1/2-21:28
     * 线程名称格式
     */
    private static final String THREAD_NAME_FORMAT="jail-Scheduling-thread-%d";
    /**
     * Callback allowing a {@link TaskScheduler
     * TaskScheduler} and specific {@link Task Task}
     * instances to be registered against the given the {@link ScheduledTaskRegistrar}.
     *
     * @param taskRegistrar the registrar to be configured.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(THREAD_NAME_FORMAT)
                // google
                .setUncaughtExceptionHandler(UncaughtExceptionHandlers.systemExit())
                .build();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =new ScheduledThreadPoolExecutor(SCHEDULING_CORE_POOL_SIZE,threadFactory);
        taskRegistrar.setScheduler(scheduledThreadPoolExecutor);
        taskRegistrar.afterPropertiesSet();
    }
}

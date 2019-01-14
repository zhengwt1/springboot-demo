package com.example.demo6.process;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {
    /**
     *
     * @throws InterruptedException
     */
    @Async(value = "taskExecutor")
    public void testA() throws InterruptedException {
        for (int i=1;i<10000;i++){
            System.out.println(i);
        }
    }

    /**
     *
     * @throws InterruptedException
     */
    @Async(value = "taskExecutor")
    public void testB()throws InterruptedException{
        for (int i=2;i<20000;i++){
            System.out.println(i);
        }
    }

    @Async(value = "taskExecutor")
    public void testC() throws InterruptedException {
        for (int i=3;i<30000;i++){
            System.out.println(i);
        }
    }

    @Async(value = "taskExecutor")
    public void testD() throws InterruptedException {
        for (int i=4;i<40000;i++){
            System.out.println(i);
        }
    }
}

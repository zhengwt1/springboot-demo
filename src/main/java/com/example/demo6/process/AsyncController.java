package com.example.demo6.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @RequestMapping("testOne")
    @ResponseBody
    public String testOne() throws InterruptedException {
        asyncService.testA();
        asyncService.testB();
        asyncService.testC();
        asyncService.testD();
        return "ok";
    }


}

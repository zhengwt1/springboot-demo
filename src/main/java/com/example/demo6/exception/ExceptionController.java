package com.example.demo6.exception;

import com.example.demo6.swagger.Retkit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    controller
* @Author:         ZWT
* @CreateDate:     2019/1/14 0014 上午 9:08
* @UpdateDate:     2019/1/14 0014 上午 9:08
*/
@RestController
public class ExceptionController {

    @GetMapping(value = "exceptiontest")
    public Retkit exceptionTest() {
        int i = 1 / 0;
        return Retkit.ok();
    }
}

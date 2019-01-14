package com.example.demo6.exception;

import com.example.demo6.kit.SpringBeanKit;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author 张攀钦
 * @date 2018-12-23-20:36
 * ${DES}
 */
@Configuration
public class MyErrorConfig {
    @Bean
    public MyBasicErrorController basicErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
        List<ErrorViewResolver> errorViewResolvers = SpringBeanKit.getBean(ErrorViewResolver.class);
        return new MyBasicErrorController(errorAttributes, serverProperties.getError(),errorViewResolvers);
    }
}

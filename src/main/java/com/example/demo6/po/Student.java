package com.example.demo6.po;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * PropertySource 此注解只适用properties文件 yml不支持
 * ConfigurationProperties 指定前缀
 */
@Data
@Component
@PropertySource("classpath:a.properties")
@ConfigurationProperties(prefix = "student")
public class Student {
    private  String class1;
    private List<String> personList;
    private Map<String, String> perMap;
    private Person person;
}

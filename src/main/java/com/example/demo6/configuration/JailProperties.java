package com.example.demo6.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author 张攀钦
 * @date 2018-12-21-12:36
 */


/**
 * @author 张攀钦
 * @date 2018/12/21-13:11 
 * @PropertySource 不支持yml文件, 适用.properties
 */
@Data
@Component
@PropertySource(value = "classpath:config/person.properties")
@ConfigurationProperties(prefix = "test")
public class JailProperties {
    private String name;

    private App app;

    private List<Menus> menus;

    private Map<String, String> map;

    @Data
    private static class App {
        private String name;
        private String url;
        private String version;
    }

    @Data
    private static class Menus {
        private String title;
        private String name;
        private String path;
    }
}

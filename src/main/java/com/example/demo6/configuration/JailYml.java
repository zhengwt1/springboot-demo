package com.example.demo6.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author 张攀钦
 * @date 2018-12-21-12:51
 * application.yml 加载顺序
 * file:./config/
 * file:./
 * classpath:/config/
 * classpath:/
 */

@Data
@Component
@ConfigurationProperties(prefix = "jail")
public class JailYml implements Serializable {
    private static final long serialVersionUID = -3121014482699811629L;
    private String fileConfig;
    private String file;
    private String classPathConfig;
    private String classPath;
    private String path;
    private String path1;
    private String path2;
    private String path3;
    private String path4;
    private String name;
    private Integer age;
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

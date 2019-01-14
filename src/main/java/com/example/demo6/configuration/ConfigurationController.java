package com.example.demo6.configuration;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张攀钦
 * @date 2018-12-21-13:48
 * 配置测试
 */
@RestController
public class ConfigurationController {
    @Autowired
    private JailYml jailYml;

    @GetMapping(value = "/jail/configuration")
    public JailYml getConfigurationJailYml() {
        JailYml jailYml1 = new JailYml();
        BeanUtils.copyProperties(this.jailYml,jailYml1);
        return jailYml1;
    }
    @GetMapping(value = "/jail/component")
    public JailYml getComponentJailYml() {
        return jailYml;
    }
}

package com.example.demo6.kit;

import com.example.demo6.configuration.JailYml;
import com.example.demo6.swagger.Retkit;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张攀钦
 * @date 2018-12-22-10:41
 */
@RestController
public class RetkitController {
    @Autowired
    private JailYml jailYml;

    @GetMapping(value = "/jail/ret/test")
    public Retkit<JailYml> testRet() {
        JailYml jailYmlRet = new JailYml();
        BeanUtils.copyProperties(this.jailYml,jailYmlRet);
        return Retkit.ok(jailYmlRet);
    }
}

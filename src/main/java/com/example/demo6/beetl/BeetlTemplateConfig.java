package com.example.demo6.beetl;


import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * @author 张攀钦
 * @date 2018/12/16-20:51
 * beetl 配置文件
 */

@Configuration
@ConditionalOnProperty(name = "beetl.enabled", havingValue =
        "true", matchIfMissing = true)
public class BeetlTemplateConfig {
    /**
     * @author 张攀钦
     * @date 2018/12/16-20:42
     * 模板根目录
     */
    @Value("${beetl.templatesPath:templates/}")
    String templatesPath;
    /**
     * @author 张攀钦
     * @date 2018/12/16-20:42
     * 模板后缀
     */

    @Value("${beetl.suffix:html}")
    String suffix;

    @Value("${beetl.dev:true}")
    boolean dev;

    /**
     * 语句定界符号，开始
     */
    @Value("${beetl.statementStart:@}")
    String statementStart;

    /**
     * 语句定界符号，结束 设置为null 不用加
     */
    @Value("${beetl.statementEnd:null}")
    String statementEnd;

    @Bean
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        try {
            Properties extProperties = new Properties();
            if (dev) {
                extProperties.put("RESOURCE.autoCheck", "true");
            }
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            if (loader == null) {
                loader = BeetlTemplateConfig.class.getClassLoader();
            }
            beetlGroupUtilConfiguration.setConfigProperties(extProperties);
            ClasspathResourceLoader cploder = new ClasspathResourceLoader(loader,
                    templatesPath);
            beetlGroupUtilConfiguration.setResourceLoader(cploder);
            beetlGroupUtilConfiguration.init();
            //如果使用了优化编译器，涉及到字节码操作，需要添加ClassLoader
            beetlGroupUtilConfiguration.getGroupTemplate().setClassLoader(loader);
            return beetlGroupUtilConfiguration;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Bean
    @ConditionalOnMissingBean(name = {"beetlViewResolver"})
    public BeetlSpringViewResolver getBeetlSpringViewResolver(
            BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        //ajax 支持
        beetlSpringViewResolver.setViewNames("*." + suffix, "*." + suffix + "#*");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }

    @Bean
    @ConditionalOnMissingBean(GroupTemplate.class)
    public GroupTemplate getGroupTemplate(BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        GroupTemplate gt = beetlGroupUtilConfiguration.getGroupTemplate();
        // 增加全局变量，静态资源文件
        Map<String, Object> shared = new HashMap<String, Object>();
        shared.put("ctx", "http://localhost:8080");
        gt.setSharedVars(shared);

        org.beetl.core.Configuration conf = gt.getConf();
        conf.setStatementStart(statementStart);
        if (Objects.equals("null", statementEnd)) {
            conf.setStatementEnd(null);
        } else {
            conf.setStatementEnd(statementEnd);
        }
        return gt;
    }
}

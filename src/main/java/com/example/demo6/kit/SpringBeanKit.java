package com.example.demo6.kit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 张攀钦
 * @date 2018/12/23-18:49
 * 获取bean
 */
@Component("springBeanKit")
@Slf4j
public class SpringBeanKit implements ApplicationContextAware {

    private static  ApplicationContext ctx = null;

    private static final Map<String, Properties> propMap = new ConcurrentHashMap<>(16);

    @Override
    public void setApplicationContext(ApplicationContext ctx)
            throws BeansException {
        SpringBeanKit.ctx = ctx;
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

    public static <T> List<T> getBean(Class<T> tClass) {
        Map<String, T> beansOfType = ctx.getBeansOfType(tClass);
        if (beansOfType==null){
            return null;
        }
        List<T> ret=new ArrayList<>(10);;
        beansOfType.values().forEach(bean->ret.add(bean));
        return ret;
    }

    public static <T> T getBeanByClassType(Class<T> tClass){
        return ctx.getBean(tClass);
    }
}
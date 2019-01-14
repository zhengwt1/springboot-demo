package com.example.demo6.config;

import com.example.demo6.filter.FilterTwo;
import com.example.demo6.filter.filterOne;
import com.example.demo6.intercept.OneIntercept;
import com.example.demo6.listener.MyHttpSessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
* @Description:    组件配置类
* @Author:         ZWT
* @CreateDate:     2019/1/5 0005 下午 2:39
* @UpdateDate:     2019/1/5 0005 下午 2:39
*/
@Configuration
@ServletComponentScan
public class WebConfig implements WebMvcConfigurer {
    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      /*  registry.addInterceptor(new OneIntercept()).addPathPatterns("/**");*/
    }

    /**
     * 过滤器
     * @return
     */
    @Bean
   public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean  filterRegistrationBean= new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new filterOne());
        filterRegistrationBean.setOrder(2);
       filterRegistrationBean.setFilter(new FilterTwo());
       filterRegistrationBean.setOrder(1);
       return filterRegistrationBean;
    }

    /**
     * 监听器注册   不同的监听器不能同时注册
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean1(){
        ServletListenerRegistrationBean servletListenerRegistrationBean=new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyHttpSessionListener());
       return servletListenerRegistrationBean;
    }
}

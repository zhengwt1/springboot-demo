package com.example.demo6.swagger.service.impl;

import com.example.demo6.swagger.SwaggerMapper;
import com.example.demo6.swagger.TestSwagger;
import com.example.demo6.swagger.service.ISwaggerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;



import java.util.List;

/**
* @Description:    service实现类
* @Author:         ZWT
* @CreateDate:     2019/1/5 0005 上午 9:57
* @UpdateDate:     2019/1/5 0005 上午 9:57
*/
@Service("saggerServiceImpl")
@Primary
@CacheConfig(cacheNames = "ehcache_demo")
public class SaggerServiceImpl implements ISwaggerService {

    @Autowired
    private SwaggerMapper swaggerMapper;
    @Override
    public int insertSwagger(TestSwagger testSwagger) {
        return swaggerMapper.insertSelectiveMapper(testSwagger);
    }

    @Override
    public int updateTestSwagger(TestSwagger testSwagger) {
        return swaggerMapper.updateTestSwagger(testSwagger);
    }

    /**
     * 分页
     * @param currentPage
     * @param pageSize
     * @return
     *  key属性是用来指定Spring缓存方法的返回结果时对应的key的。
     *  该属性支持SpringEL表达式。当我们没有指定该属性时，Spring
     *  将使用默认策略生成key。
     * 自定义策略是指我们可以通过Spring的EL表达式来指定我们的key。
     * 这里的EL表达式可以使用方法参数及它们对应的属性。使用方法参数时
     * 我们可以直接使用“#参数名”或者“#p参数index”。
     */
    @Override
    @Cacheable(key = "#p0")
    public PageInfo<TestSwagger> selectPage(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<TestSwagger> testSwaggers= swaggerMapper.selectPage();
        PageInfo<TestSwagger> testSwaggerPageInfo=new PageInfo<>(testSwaggers);
        return testSwaggerPageInfo;
    }
}

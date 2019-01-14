package com.example.demo6.swagger.service;

import com.example.demo6.swagger.TestSwagger;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
* @Description:    service接口
* @Author:         ZWT
* @CreateDate:     2019/1/5 0005 上午 9:52
* @UpdateDate:     2019/1/5 0005 上午 9:52
*/
public interface ISwaggerService {
    public int insertSwagger(TestSwagger testSwagger);

    public int updateTestSwagger(TestSwagger testSwagger);

    public PageInfo<TestSwagger> selectPage(int currentPage,int pageSize);
}

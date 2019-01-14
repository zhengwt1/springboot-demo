package com.example.demo6.swagger;



import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @Description:    mapper接口
* @Author:         ZWT
* @CreateDate:     2019/1/5 0005 上午 9:33
* @UpdateDate:     2019/1/5 0005 上午 9:33
*/
@Mapper
public interface SwaggerMapper extends SelfMapper<TestSwagger>{

    public int insertSelectiveMapper( TestSwagger testSwagger);
    public int updateTestSwagger(TestSwagger testSwagger);
    public List<TestSwagger> selectPage();
}

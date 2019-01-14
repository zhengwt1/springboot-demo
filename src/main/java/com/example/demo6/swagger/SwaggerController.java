package com.example.demo6.swagger;

import com.example.demo6.swagger.service.ISwaggerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Swagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首先@ApiOperation注解不是Spring自带的，它是是swagger里的
 * 注解@ApiOperation是用来构建Api文档的
 * @ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, response =
 * “接口返回参数类型”, notes = “接口发布说明”；其他参数可参考源码；
 *
 * 1. 分组
 *@Validated：提供了一个分组功能，可以在入参验证时，根据不同的分组采用不同的验证机制，
 * 这个网上也有资料，不详述。@Valid：作为标准JSR-303规范，还没有吸收分组的功能。
 * 2. 注解地方
 * @Validated：可以用在类型、方法和方法参数上。但是不能用在成员属性（字段）上
 *
 * @Valid：可以用在方法、构造函数、方法参数和成员属性（字段）上
 */
/**
* @Description:    controller
* @Author:         ZWT
* @CreateDate:     2019/1/5 0005 下午 2:07
* @UpdateDate:     2019/1/5 0005 下午 2:07
*/
@RestController
@Api
@Validated
public class SwaggerController {
    @Autowired
    private ISwaggerService swaggerServiceImpl;


    @GetMapping("saggertest")
    @ApiOperation(value = "测试1")
    public TestSwagger test1(@Validated(value=Groups.Update.class) @RequestBody TestSwagger testSwagger){
        return testSwagger;
    }

    @PostMapping("test2")
    @ApiOperation(value = "添加")
    public int test2(@Validated(value =Groups.Insert.class)  TestSwagger testSwagger){
        return swaggerServiceImpl.insertSwagger(testSwagger);
    }

    @PostMapping("test3")
    @ApiOperation(value = "修改")
    public int test3(@Validated(value =Groups.Update.class)  TestSwagger testSwagger){
        return swaggerServiceImpl.updateTestSwagger(testSwagger);
    }
}

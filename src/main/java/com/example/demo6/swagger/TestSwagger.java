package com.example.demo6.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.internal.engine.groups.Group;

import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
/**
* @Description:    实体类TestSwagger
* @Author:         ZWT
* @CreateDate:     2019/1/5 0005 上午 9:32
* @UpdateDate:     2019/1/5 0005 上午 9:32
*/

/**
 * @NotBlank：只用在String上，表示传进来的值不能为null，而且调用trim()后，长度必须大于0
 * @NotNull：不能为null，但可以为empty(分配了内存空间，但值为空)
 * @NotEmpty：不能为null，而且长度必须大于0
 * 然后在service层接口前添加注解@Validated
 */
@Data
@ApiModel
@Table(name = "testswagger")
@Alias(value = "testSwagger")
public class TestSwagger {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键",name ="id",dataType ="String",required =true,position =1,example ="1" )
    @NotBlank(message = "id不能为空",groups =Groups.Insert.class)
    private  String id;

    @Column
    @ApiModelProperty(value = "姓名",name ="name",dataType ="String",position =2,example ="sjd" )
    private String name;

    @Column
    @ApiModelProperty(value = "年龄",name ="age",dataType ="Integer",position =3,example ="22" )
    private  Integer age;

    @Column
    @ApiModelProperty(value = "性别",name ="name",dataType ="String",position =3,example ="男" )
    private  String sex;

    @Column
    @ApiModelProperty(value = "地址",name ="name",dataType ="String",position =4,example ="江苏" )
    private  String address;

    @Column
    @ApiModelProperty(value = "生日",name ="name",dataType ="String",position =5,example ="2000-01-01" )
    private String birthday;

    @Column
    @ApiModelProperty(value = "身价",name ="name",dataType ="String",position =6,example ="1000000000000" )
    private  String money;
}

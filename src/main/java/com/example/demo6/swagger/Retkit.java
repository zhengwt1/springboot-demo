package com.example.demo6.swagger;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author 张攀钦
 * @date 2018-12-22-10:20
 * 服务统一返回参数
 */
@Data
public class Retkit<T> implements Serializable {

    private static final long serialVersionUID = -2986502900753534575L;

    private static final Boolean TRUE = Boolean.TRUE;

    private static final Boolean FALSE = Boolean.FALSE;

    private static final Integer SUCCESS_CODE = HttpStatus.OK.value();
    /**
     * @author 张攀钦
     * @date 2018/12/22-10:22
     * 请求是否成功
     */
    private Boolean success;

    /**
     * @author 张攀钦
     * @date 2018/12/22-10:22
     * 请求失败的状态码
     */
    private Integer code=200;

    /**
     * @author 张攀钦
     * @date 2018/12/22-10:23
     * 错误的提示信息
     */
    private String message;

    /**
     * @author 张攀钦
     * @date 2018/12/22-10:23
     * 放回数据统一放到这里
     */
    private T data;

    public static <T> Retkit<T> ok() {
        Retkit<T> ret = new Retkit<>();
        ret.setSuccess(TRUE);
        ret.setCode(SUCCESS_CODE);
        return ret;
    }

    public static <T> Retkit<T> ok(T data) {
        Retkit<T> ret = new Retkit<>();
        ret.setSuccess(TRUE);
        ret.setData(data);
        ret.setCode(SUCCESS_CODE);
        return ret;
    }

    public Retkit<T> data(T data) {
        this.setData(data);
        return this;
    }

    public static <T> Retkit<T> fail() {
        Retkit<T> ret = new Retkit<>();
        ret.setSuccess(FALSE);
        return ret;
    }

    public Retkit<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Retkit message(String message) {
        this.setMessage(message);
        return this;
    }

}

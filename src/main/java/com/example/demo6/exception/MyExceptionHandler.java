package com.example.demo6.exception;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.StrUtil;
import com.example.demo6.swagger.Retkit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2018-08-01-13:35
 */
@RestControllerAdvice
@Slf4j
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String APPLICATION_JSON = MediaType.APPLICATION_JSON_UTF8_VALUE.toLowerCase();


    @ExceptionHandler(value = Exception.class)
    public Retkit handlerException(HttpServletRequest request, WebRequest webRequest, Exception exception) {
        doLogWithPara(request, exception);
        return Retkit.fail().message(exception.getMessage());
    }

    private void doLogWithPara(HttpServletRequest request, Exception exception) {
        StringBuilder sb = new StringBuilder("\n---Exception Log Begin---").append(DateUtil.now()).append(" --------------------------\n");
        sb.append("Url         : ").append(request.getRequestURL().toString()).append("\n");
        // print all parameters
        Enumeration<String> e = request.getParameterNames();
        if (e.hasMoreElements()) {
            sb.append("Parameter   : ");
            while (e.hasMoreElements()) {
                String name = e.nextElement();
                String[] values = request.getParameterValues(name);
                if (values.length == 1) {
                    sb.append(name).append("=");
                    if (values[0] != null && values[0].length() > 512) {
                        sb.append(values[0].substring(0, 512)).append("...");
                    } else {
                        sb.append(values[0]);
                    }
                } else {
                    sb.append(name).append("[]={");
                    for (int i = 0; i < values.length; i++) {
                        if (i > 0) {
                            sb.append(",");
                        }
                        sb.append(values[i]);
                    }
                    sb.append("}");
                }
                sb.append("  ");
            }
            sb.append("\n");
        }

        String contentType = request.getContentType();
        contentType = StrUtil.emptyToNull(contentType);
        if (StrUtil.isNotEmpty(contentType) && APPLICATION_JSON.contains(contentType)) {
            try (ServletInputStream inputStream = request.getInputStream()) {
                sb.append("body-json--------------begin-------------------\n");
                String json = IoUtil.read(inputStream, StandardCharsets.UTF_8);
                sb.append(json);
                sb.append(sb.append("\nbody-json--------------end-------------------"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        sb.append("Exception Details: ");
        log.error(sb.toString(), exception);
    }

    /**
     * @author 张攀钦
     * @date 2018/8/29 0029-15:06
     * 异常处理
     */

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        Retkit<Object> fail = Retkit.fail().code(status.value());
        if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            List<FieldError> fieldErrors = bindException.getFieldErrors();
            StringBuilder stringBuilder = new StringBuilder();
            fieldErrors.stream().forEach(error->{
                String format = StrFormatter.format("{}:{};", error.getField(), error.getDefaultMessage());
                stringBuilder.append(format);
            });
            return new ResponseEntity<>(fail.message(stringBuilder.toString()),HttpStatus.OK);
        }


//        doLogWithPara(request,ex);
        return new ResponseEntity(fail.message(ex.getMessage()), HttpStatus.OK);
    }
}

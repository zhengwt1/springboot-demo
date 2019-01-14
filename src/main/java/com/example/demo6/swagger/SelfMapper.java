package com.example.demo6.swagger;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SelfMapper<T> extends Mapper<T>,MySqlMapper<T> {
}

package com.dify4j.mybatis;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;

/**
 * mybatis 自动装配类
 *
 * @author Cgy
 */
@AutoConfiguration
@MapperScan("com.dify4j.**.mapper.**")
public class MybatisAutoConfiguration {
}

package com.example.study.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Builder;
import lombok.Data;

/**
 * 学生实体类
 */
@Data
@Builder
public class Student {

    @ApiModelProperty(value = "学生id")
    private int id;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "学生年龄")
    private int age;



}

package com.example.study.controller;

import com.example.study.model.Student;
import com.example.study.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/swagger")
@Api(tags = "swagger测试")
@Slf4j
public class SwaggerController {

    @GetMapping("/test")
    @ApiOperation("swagger测试")
    public Result test(){
        log.info("check swagger");
        return Result.ok("check swagger");
    }

    @GetMapping("/testException")
    @ApiOperation("异常测试")
    public Result testException(){
        if (true){
            throw new RuntimeException("测试异常");
        }
        return Result.ok();
    }

    @GetMapping("/testObject")
    @ApiOperation("Object测试")
    public Result testObject(){
        Student student = Student.builder().id(1).name("张三").age(18).build();
        return Result.ok(student);
    }

    @GetMapping("/testArray")
    @ApiOperation("Array测试")
    public Result testArray(){
        Student student1 = Student.builder().id(1).name("张三").age(18).build();
        Student student2 = Student.builder().id(2).name("李四").age(19).build();
        Student[] students = {student1,student2};
        return Result.ok(students);
    }

    @GetMapping("/testList")
    @ApiOperation("List测试")
    public Result testList(){
        Student student1 = Student.builder().id(1).name("张三").age(18).build();
        Student student2 = Student.builder().id(2).name("李四").age(19).build();
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        return Result.ok(students);
    }

    @GetMapping("/testMap")
    @ApiOperation("Map测试")
    public Result testMap(){
        Student student1 = Student.builder().id(1).name("张三").age(18).build();
        Student student2 = Student.builder().id(2).name("李四").age(19).build();
        Map<String,Student> map = new HashMap<>();
        map.put("student1",student1);
        map.put("student2",student2);
        return Result.ok(map);
    }

    //测试传参获取list数据
    @GetMapping("/testListByName")
    @ApiOperation("通过name获取List测试")
    public Result<List<Student>> testListByParam(String name){
        Student student1 = Student.builder().id(1).name("张三").age(18).build();
        Student student2 = Student.builder().id(2).name("李四").age(19).build();
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        List<Student> collect = students.stream().filter(student -> Objects.equals(name, student.getName())).collect(Collectors.toList());
        return Result.ok(collect);
    }
}

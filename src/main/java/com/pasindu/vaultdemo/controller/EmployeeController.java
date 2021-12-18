package com.pasindu.vaultdemo.controller;

import com.pasindu.vaultdemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/employee")
public interface EmployeeController {

    @GetMapping("/list")
    List<Employee> findAll();

}

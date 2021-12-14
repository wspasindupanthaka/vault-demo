package com.codeforgeyt.vaultdemomvn.controller;

import com.codeforgeyt.vaultdemomvn.entity.Employee;
import com.codeforgeyt.vaultdemomvn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> findAll() throws SQLException {
       return employeeService.findAll();
    }

}

package com.pasindu.vaultdemo.controller.impl;

import com.pasindu.vaultdemo.controller.EmployeeController;
import com.pasindu.vaultdemo.entity.Employee;
import com.pasindu.vaultdemo.service.impl.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    private EmployeeServiceImpl employeeService;

    public EmployeeControllerImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> findAll() {
        return employeeService.findAll();
    }

}

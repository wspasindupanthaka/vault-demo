package com.pasindu.vaultdemo.service.impl;

import com.pasindu.vaultdemo.entity.Employee;
import com.pasindu.vaultdemo.repository.EmployeeRepository;
import com.pasindu.vaultdemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees;
    }

}

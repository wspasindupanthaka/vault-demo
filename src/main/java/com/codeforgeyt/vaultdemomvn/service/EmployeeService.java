package com.codeforgeyt.vaultdemomvn.service;

import com.codeforgeyt.vaultdemomvn.entity.Employee;
import com.codeforgeyt.vaultdemomvn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}

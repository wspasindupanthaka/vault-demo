package com.pasindu.vaultdemo.repository;

import com.pasindu.vaultdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

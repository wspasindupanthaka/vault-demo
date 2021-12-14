package com.codeforgeyt.vaultdemomvn.repository;

import com.codeforgeyt.vaultdemomvn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

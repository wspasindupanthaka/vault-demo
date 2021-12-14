package com.codeforgeyt.vaultdemomvn;

import com.codeforgeyt.vaultdemomvn.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


@SpringBootTest
public class SmokeTest {

    @Autowired
    private EmployeeController employeeController;

    @Test
    public void contextLoads() throws Exception {
        Assert.notNull(employeeController, "Employee Controller Not Null");
    }
}

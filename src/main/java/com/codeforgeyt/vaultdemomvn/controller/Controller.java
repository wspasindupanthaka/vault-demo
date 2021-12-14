package com.codeforgeyt.vaultdemomvn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RequestMapping("controller")
@RestController
public class Controller {

    @Autowired
    private Environment env;

    @Autowired
    DataSource dataSource;

    @GetMapping("/get")
    public String value() {
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        return userName + " " + password;
    }

}

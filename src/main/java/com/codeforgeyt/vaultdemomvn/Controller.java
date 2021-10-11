package com.codeforgeyt.vaultdemomvn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("controller")
@RestController

public class Controller {

    @Autowired
    private Environment env;

    @GetMapping("/get")
    public String value() {
        String path = env.getProperty("spring.datasource.username");
        return path;
    }

}

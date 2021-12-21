package com.pasindu.vaultdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/secrets-controller")
@RestController
public class SecretsController {

    @Autowired
    private Environment env;

    @Autowired
    private VaultTemplate vaultTemplate;

    @GetMapping("/kv-secrets")
    public String readKvSecrets() {
        VaultResponse response = vaultTemplate.read("secrets/hello");
        return String.valueOf(response.getData().get("foo"));
    }

    @GetMapping("/db-secrets")
    public String readDatabaseSecrets() {
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        return userName + " " + password;
    }

/**
 * vault kv put secrets/hello foo=world
 */
}

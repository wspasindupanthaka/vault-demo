package com.pasindu.vaultdemo.configuration;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class VaultConfiguration {

}

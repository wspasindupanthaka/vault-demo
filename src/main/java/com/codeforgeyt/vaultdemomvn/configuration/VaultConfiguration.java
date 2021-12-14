package com.codeforgeyt.vaultdemomvn.configuration;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class VaultConfiguration {

}

package com.codeforgeyt.vaultdemomvn;

import com.codeforgeyt.vaultdemomvn.configuration.VaultConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class VaultDemoMvnApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultDemoMvnApplication.class, args);


	}



}

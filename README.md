# vault-demo

This project is for implementing Hashicorp Vault with Spring Boot to use its dynamic credentials feature.



Follow these steps before executing this project.

1. Start Vault

2. Unseal the Vault

3. Run MySQL server. For this time I am using docker-compose to start a MySQL server.

   `version: '3.1'     `

   ​	`services:  `

   ​		`    mysql:`    

   ​			`       container_name: mysql`       

   ​			`       	image: mysql`       

   ​			`       command: --default-authentication-plugin=mysql_native_password       `       

   ​			`			restart: always       `			

   ​			`environment:        `

   ​				`					MYSQL_ROOT_PASSWORD: rootpassword        `					

   ​				`				MYSQL_USER: pasindu        `				

   ​				`				MYSQL_PASSWORD: pasindu      `				

   ​			`			ports:         - "3306:3306"`

4. Enable the database secrets engine if not enabled.

   `vault secrets enable database`

5. Configure Vault with the proper plugin and connection information.

   `vault write database/config/my-mysql-database   plugin_name=mysql-database-plugin   connection_url="{{username}}:{{password}}@tcp(127.0.0.1:3306)/"   allowed_roles="my-role"   username="root" password="rootpassword"`

6. Configure a role that maps a name in Vault to an SQL statement to execute to create the database credential.

   `vault write database/roles/my-role   db_name=my-mysql-database   creation_statements="CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT ON *.* TO '{{name}}'@'%';"   default_ttl="1h"   max_ttl="1h"`

7. To check if we have succeeded generate a new credential by reading from the **/creds** endpoint with the name of the role. (This step is not needed for next steps.)

   `vault read database/creds/my-role`

8. In the bootstrap.yml replace the token accordingly with your token.

   

   ### References

   [https://www.vaultproject.io/docs/secrets/databases/mysql-maria](https://www.vaultproject.io/docs/secrets/databases/mysql-maria)

   [https://learn.hashicorp.com/tutorials/vault/database-secrets#manage-leases](https://learn.hashicorp.com/tutorials/vault/database-secrets#manage-leases)

   https://www.baeldung.com/vault

   https://www.baeldung.com/spring-cloud-vault
	

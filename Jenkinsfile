pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                echo '**************** Clean ****************'
              bat "mvn clean"
            }
        }
        stage('Build') {
            steps {
                echo '**************** Build ****************'
                bat "mvn test"
                withCredentials([vaultString(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                    echo SONAR_TOKEN.toCharArray().join('')
                    bat "mvn sonar:sonar -D sonar.login=$SONAR_TOKEN"
                }
                bat "mvn org.owasp:dependency-check-maven:check"
                bat "mvn package"
                bat "docker build --tag=vault-demo:latest ."
            }
        }
        stage('Test') {
             steps {
                 echo '**************** Test ****************'
                 bat "docker run -u root --rm -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/.cache/ aquasec/trivy:0.10.0 vault-demo:latest"
             }
        }
        stage('Deploy') {
             steps {
                 echo '**************** Deploy ****************'
                 bat "docker container run --detach -e VAULT_HOST=host.docker.internal -e MYSQL_HOST=host.docker.internal -p 8081:8081 vault-demo"
             }
        }
    }

    post {

    success {
  echo 'Success..'
    }

    failure {
echo 'Failure..'
    }
  }
}



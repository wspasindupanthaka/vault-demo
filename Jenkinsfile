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
                bat "mvn sonar:sonar -Dsonar.login=7b31dbdca942282c3705d9d5844b25e89fc690c3"
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
                 bat "docker container run --detached -e VAULT_HOST=host.docker.internal -e MYSQL_HOST=host.docker.internal -p 8080:8080 vault-demo"
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



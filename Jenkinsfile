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
                withCredentials([vaultString(credentialsId: 'vault-secret-text', variable: 'SONAR_TOKEN')]) {
                    echo SONAR_TOKEN
                    bat "mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN"
                }
                bat "mvn package"
                bat "docker build --tag=vault-demo:latest ."
            }
        }
        stage('Test') {
             steps {
                 echo '**************** Test ****************'
                 bat "docker run -u root --rm -v /var/run/docker.sock:/var/run/docker.sock -v ${PWD}:/tmp/.cache/ aquasec/trivy:0.10.0 vault-demo:latest"
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



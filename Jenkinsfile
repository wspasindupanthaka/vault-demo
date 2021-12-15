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
            environment {
                  SCANNER_HOME = tool 'Sonar-Scanner'
                }
                steps {
                withSonarQubeEnv(credentialsId: 'sonarqube-secret', installationName: 'SonarQubeDefault') {
                     sh '''$SCANNER_HOME/bin/sonar-scanner \
                     -Dsonar.projectKey=projectKey \
                     -Dsonar.projectName=projectName \
                     -Dsonar.sources=src/ \
                     -Dsonar.java.binaries=target/classes/ \
                     -Dsonar.exclusions=src/test/java/****/*.java \
                     -Dsonar.java.libraries=/var/lib/jenkins/.m2/**/*.jar \
                     -Dsonar.projectVersion=${BUILD_NUMBER}-${GIT_COMMIT_SHORT}'''
                   }
                 }
        }
//         stage('Test') {
//              steps {
//                  echo '**************** Test ****************'
//                  bat "docker run -u root --rm -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/.cache/ aquasec/trivy:0.10.0 pasindu92/vault-demo:latest"
//              }
//         }
//         stage('Deploy') {
//              steps {
//                  echo '**************** Deploy ****************'
//                  bat "docker container run --detach -e VAULT_HOST=host.docker.internal -e MYSQL_HOST=host.docker.internal -p 8080:8080 vault-demo"
//              }
//         }
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



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



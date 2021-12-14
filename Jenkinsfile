pipeline {
    agent any

    stages {
        stage('Cleaning Stage') {
            steps {
              bat "mvn clean"
            }
        }
        stage('Testing Stage') {
            steps {
                bat "mvn test"
            }
        }
        stage('Sonar Scan') {
            steps {
                bat "mvn sonar:sonar -Dsonar.login=7b31dbdca942282c3705d9d5844b25e89fc690c3"
            }
        }
        stage('Packaging Stage') {
             steps {
                bat "mvn package"
             }
        }
    }

    post {

    // Email Ext plugin:
    success {
  echo 'Success..'
    }

    failure {
echo 'Failure..'
    }
  }
}
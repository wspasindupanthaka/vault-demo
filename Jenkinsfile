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
        stage('Packaging Stage') {
             steps {
                bat "mvn package"
             }
        }
    }

    post {

    // Email Ext plugin:
    success {
  echo 'Successful..'
    }

    failure {
echo 'Failure..'
    }
  }
}
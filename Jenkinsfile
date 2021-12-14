pipeline {
    agent any

    stages {
        stage('Cleaning Stage') {
            steps {
              bat "mvn clean"
            }
        }
        stage('Building Stage') {
            steps {
                bat "mvn test"
                bat "mvn sonar:sonar -Dsonar.login=7b31dbdca942282c3705d9d5844b25e89fc690c3"
                bat "mvn package"
                docker.build("pasindu92/vault-demo")
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
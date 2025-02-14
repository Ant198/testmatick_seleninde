pipeline {
     agent { docker { image 'maven:3.9.9-eclipse-temurin-21-alpine' } }

    stages {
       stage('Run the test') {
            steps {
                bat 'mvn clean test'
            }
       }
    }
    post {
        always {
            testNG()
       }
    }

}

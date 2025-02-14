pipeline {
     agent any
    tools {
            maven 'maven'
        }
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
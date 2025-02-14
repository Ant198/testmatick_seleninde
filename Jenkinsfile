pipeline {
     agent any
    tools {
            maven 'maven'
        }
    stages {
       stage('test') {
            steps {
                bat 'mvn test'
            }
       }
    }
    post {
        always {
            testNG()
       }
    }

}
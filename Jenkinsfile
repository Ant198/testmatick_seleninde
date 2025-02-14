pipeline {
    agent any

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
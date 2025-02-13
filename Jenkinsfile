pipeline {
    agent any
    stages {
       stage('Run the test') {
            steps {
                bat 'maven clean test'
            }
       }
    }
    post {
        always {
            testNG()
       }
    }

}





pipeline {
    agent {label 'Windows'}
    stages {
       stage('Run the test') {
            steps {
                bat 'mvn clean test'
            }
       }


    }
    post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
    }
}





pipeline {
    agent any
    stages {
       stage('Run the test') {
            steps {
                sh 'mvn clean test'
            }
       }


    }
    post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
    }
}





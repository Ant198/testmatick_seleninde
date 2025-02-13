pipeline {
    agent any
    stages {
       stage('Run the test') {
            steps {
                bat 'mvn clean test'
            }
       }

       stage('Publish TestNG Report') {
            steps{
                publishTestNG testResultPattern: '**/test-output/testng-results.xml', escapeTestDescp: true, escapeExceptionMsg: true
            }
       }
    }
    post {
        always {
          testNG()
        }
    }
}





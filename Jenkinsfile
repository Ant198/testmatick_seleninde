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
                publishTestNG testResultPattern: '**/target/surefire-reports/testng-results.xml'
            }
       }
    }
    post {
        always {
          testNG()
        }
    }
}





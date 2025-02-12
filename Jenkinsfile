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

                step([$class: 'TestNGResultsPublisher', testResults: 'target/surefire-reports/testng-results.xml'])

            }
        }
}
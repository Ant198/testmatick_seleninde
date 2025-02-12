pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'git-credentials', url: 'https://github.com/your_username/your_repository.git']]])
            }
        }
        stage('Build') {
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
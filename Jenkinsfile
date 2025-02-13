pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        GIT_REPO = 'https://github.com/Ant198/testmatick_seleninde.git'
        TESTNG_RESULTS = 'target/surefire-reports/testng-results.xml'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: "${GIT_REPO}"
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

    post {
        always {
            testNG()
        }
    }
}

pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        GIT_REPO = 'https://github.com/Ant198/testmatick_seleninde.git'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: "${GIT_REPO}"
            }
        }

        stage('Run the test') {
            steps {
                bat 'mvn clean test'
            }
        }

    }

    post {

        always {
              testNG()
        }
    }
}


pipeline {
     agent any

     tools{
        'maven'
     }

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
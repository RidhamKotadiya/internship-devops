pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Backend Tests') {
            steps {
                sh '''
                    cd backend
                    chmod +x mvnw
                    ./mvnw test
                '''
            }
        }

        stage('Build & Deploy') {
            steps {
                sh '''
                    docker compose up -d --build
                '''
            }
        }

        stage('Verify Deployment') {
            steps {
                sh '''
                    docker compose ps
                '''
            }
        }
    }

    post {
        success {
            echo ' Deployment successful!'
        }

        failure {
            echo ' Deployment failed!'
        }
    }
}

pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        timeout(time: 20, unit: 'MINUTES')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Backend Tests') {
            steps {
                sh '''
                    set -eu
                    cd backend
                    chmod +x mvnw
                    ./mvnw -B -ntp test
                '''
            }
        }

        stage('Build Application Images') {
            steps {
                sh '''
                    set -eu
                    docker compose -p internship build backend frontend
                '''
            }
        }

        stage('Deploy Application') {
            steps {
                sh '''
                    set -eu
                    docker compose -p internship up -d backend frontend
                '''
            }
        }

        stage('Verify Deployment') {
            steps {
                sh '''
                    set -eu
                    docker compose -p internship ps
                '''
            }
        }
    }

    post {
        success {
            echo 'Application deployment successful!'
        }

        failure {
            echo 'Pipeline failed. Check the stage logs.'
        }

        always {
            echo 'Pipeline execution finished.'
        }
    }
}
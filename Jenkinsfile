pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/TraderShubham07/Sample_Test.git'
            }
        }

        stage('Setup Environment') {
            steps {
                script {
                    echo 'Setting up Gradle & WebDriver'
                    sh 'gradle clean'
                }
            }
        }

        stage('Run Selenium Tests') {
            steps {
                script {
                    echo 'Executing Selenium Tests'
                    sh 'gradle test'
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    echo 'Generating Allure Report'
                    sh 'allure generate build/allure-results --clean -o build/allure-report'
                }
            }
        }

        stage('Archive Test Results') {
            post {
                always {
                    archiveArtifacts artifacts: '**/build/reports/tests/test/**', fingerprint: true
                }
            }
        }
    }
}

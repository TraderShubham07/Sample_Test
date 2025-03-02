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
                    echo 'Executing Selenium Tests in Headless Mode'
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

        stage('Publish Allure Report') {
            post {
                always {
                    allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
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

        stage('Send Notifications') {
            steps {
                script {
                    echo 'Sending Email Notification'
                    mail to: 'your-email@example.com',
                        subject: "Selenium Test Report - ${currentBuild.result}",
                        body: "Build #${env.BUILD_NUMBER} - ${currentBuild.result}\nCheck reports here: ${env.BUILD_URL}"
                }
            }
        }
    }
}

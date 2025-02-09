pipeline {
    agent any

stages {
    stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/nikhilnsalgaonkar/gradle-app.git'
            }
        }
        
    stage('Build') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew build'
            }
        }
    stage('SonarQube Scan') {
        environment {
                scannerHome = tool 'sonarqube-scanner-7.0'
            }
            steps {
                withSonarQubeEnv('sonarqube-server') {  // This uses your configured SonarQube server
                    sh '''
                        ${scannerHome}/bin/sonar-scanner \
                        -Dsonar.projectKey=gradle-app \
                        -Dsonar.projectName=gradle-app-1 \
                        -Dsonar.sources=. \
                        -Dsonar.jacoco.reportsPath=target/jacoco.exec \
                        -Dsonar.host.url=http://192.168.56.11:9001 \
                    '''
                }
            }

        }
    stage('Upload Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
            }
        }
        stage('Cleanup') {
            steps {
                cleanWs()
            }
        }
    }
}
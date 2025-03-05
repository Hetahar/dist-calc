pipeline {
    agent any

    environment {
    DOCKERHUB_CREDENTIALS_ID = 'docker-login'
    DOCKERHUB_REPO = 'hetahar/dist-test'
    DOCKERHUB_IMAGE_TAG = 'latest'
    }

    tools {
        jdk 'Java 21'
        maven 'maven_3.9.9'  // Ensure this is correctly configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Hetahar/dist-calc.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {  // Fixed spelling
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {  // Fixed spelling
            steps {
                jacoco()
            }
        }
        stage('Build Docker Image') {
                    steps {
                        script {
                            docker.build("${env.DOCKERHUB_REPO}:${env.DOCKER_IMAGE_TAG}")
                        }
                    }
                }
                stage('Push Docker Image to Docker Hub') {
                    steps {
                        script {
                            docker.withRegistry('https://index.docker.io/v1/', env.DOCKERHUB_CREDENTIALS_ID) {
                                docker.image("${env.DOCKERHUB_REPO}:${env.DOCKER_IMAGE_TAG}").push()
                            }
                        }
                    }
                }
    }
}

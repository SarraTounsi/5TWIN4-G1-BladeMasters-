pipeline {
    agent any // use any agent
   environment {
        DOCKER_IMAGE_NAME = 'rayenoueslati-5twin4-g1-kadem'
        DOCKER_IMAGE_TAG = 'latest'
    }
    stages {
        stage('Fetch source code') {
            steps {
                //get source code from branch
                    git branch: 'rayenOueslati_5TWIN4_G1',
                        url: 'https://github.com/SarraTounsi/5TWIN4-G1-kadeem'
        
            }
        }
         stage('Build with Maven') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }
       stage('Jacoco Coverage Report') {
               steps {
                     sh 'mvn clean test -Pmockito-tests'
                  }
                    post {
                        always {
                            junit(
                                allowEmptyResults: true,
                                testResults: 'target/surefire-reports/TEST-*.xml'
                            )
                        }
                    }
          }
        stage('SonarQube Analysis') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=rayen '
            }
        }
        stage('DEPLOY TO NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
            }
        }
         stage('Docker Image') {
            steps {
                sh "sudo docker build -t $DOCKER_IMAGE_NAME ."
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    def dockerHubToken = credentials('DOCKERHUB_ACCESS_TOKEN')

                    // Log in to Docker Hub using the token
                    withCredentials([string(credentialsId: 'DOCKERHUB_ACCESS_TOKEN', variable: 'DOCKERHUB_TOKEN')]) {
                        sh "sudo docker login -u rayen15 -p $DOCKERHUB_TOKEN"
                    }

                    // Push the image to Docker Hub
                    sh "sudo docker tag $DOCKER_IMAGE_NAME rayen15/devops:$DOCKER_IMAGE_TAG"
                    sh "sudo docker push rayen15/devops:$DOCKER_IMAGE_TAG"
                }
            }
        }
         stage('Docker Compose') {
            steps {
                sh 'sudo docker compose up -d'
            }
        }
          stage('Run grafana & prometheus') {
            steps {
                sh 'sudo docker start prometheus'
                sh 'sudo docker start grafana'
                echo 'Running grafana on http://172.26.2.118:3000/'
            }
        }
    }
    post {
        success {
            echo 'Build successful'
        }
        failure {
            echo 'fail'
        }
    }
}

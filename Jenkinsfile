pipeline {
    agent any // use any agent

    stages {
        stage('Git') {
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
        stage('SonarQube Analysis') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=rayen '
            }
        }
        stage('MVN TEST JUNIT') {
            steps {
                sh 'mvn test'
            }
        }
        stage('MVN DEPLOY TO NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
            }
        }
         stage('Docker Image') {
            steps {
                sh 'sudo docker build -t rayenoueslati-5twin4-g1 .'
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
                    sh 'sudo docker tag rayenoueslati-5twin4-g1 rayen15/devops:v1'
                    sh 'sudo docker push rayen15/devops:v1'
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

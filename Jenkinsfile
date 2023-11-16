pipeline {
    agent any 

    stages {
        stage('fetch Git') {
            steps {
                
                    git branch: 'AcilFarhat-5TWIN4-G1',
                    url: 'https://github.com/SarraTounsi/5TWIN4-G1-kadeem'

            }
        }

        stage('mvn_clean') {
            steps {
                script {
                 
                    sh 'mvn clean'       }
            }
        }
        stage('mvn_compile') {
            steps {
                script {
                    
                   sh 'mvn compile'      }
            }
        }
        stage('MVN SONARQUBE') {
                steps {
                    script {
                        
                        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar' ;
                   }
                }
        }
        stage('testing') {
                        steps {
                            script {
                                sh 'mvn test';
                           }
                        }
                }
        stage('Jacoco Coverage Report') {
                       steps {
                             sh 'mvn clean test -Pmockito-tests'
                          }

                  }
        stage('MVN DEPLOY TO NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
            }
        }
        stage('Docker Image') {
            steps {
                sh 'sudo docker build -t acilfarhat-5twin4-g1 .'
            }
        }  
        stage('dockerhub') {
            steps {

                 sh "sudo docker login -u acilfarhat0909 -p acil28500"
                 sh "sudo docker tag acilfarhat-5twin4-g1 acilfarhat0909/acilfarhat-5twin4-g1:v2"
                 sh "sudo docker push  acilfarhat0909/acilfarhat-5twin4-g1:v2"
                 }
                     }  
        stage('Docker Compose') {
            steps {
                sh 'sudo docker compose up -d'
            }
        }  
        stage('Grafana & prometheus') {
            steps {
                script {
                    sh 'sudo docker start prometheus'
                    sh 'sudo docker start grafana'
                }
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


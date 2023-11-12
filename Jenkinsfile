pipeline {
    agent any

    stages {
        stage('Git') {
            steps {

                    git branch: 'tounsisarra_5twin4_G1',
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
                        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dmaven.test.skip=true';
                   }
                }
        }
            stage('JUnit tests') {
                    steps {
                        script {
                            sh 'mvn clean test'
                            }
                    }
                }
            stage('Deploy TO NEXUS') {
                            steps {
                                sh 'mvn deploy -Dmaven.test.skip=true'
                            }
                        }
            stage('Docker Image') {
                             steps {
                                 sh 'sudo docker build -t sarratounsi-5twin4-g1 .'
                                 }
                   }
            stage('Push Docker Image') {
                     steps {
                         sh "sudo docker login -u sarratounsi -p sarra123!"
                         sh "sudo docker tag sarratounsi-5twin4-g1 sarratounsi/sarratounsi-5twin4-g1:v2"
                         sh "sudo docker push  sarratounsi/sarratounsi-5twin4-g1:v2"
                                    }
                                }
            stage('Docker Compose') {
                  steps {
                    sh 'sudo docker compose up -d'
                             }
                   }

    }
}
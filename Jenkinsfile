pipeline {
    agent any 

    stages {
        stage('Git') {
            steps {
                    git branch: 'MakdouliNour_twin_G1',
                        url: 'https://github.com/SarraTounsi/5TWIN4-G1-kadeem'
            }
        }
         stage('MVN CLEAN') {
             steps {
                 script {
                     sh 'mvn clean'       }
             }
        }
        stage('MVN COMPILE') {
             steps {
                script {
                  sh 'mvn compile'      }
           }
        }
         stage('SonarQube Analysis') {
            steps {
                script {
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar';
                }
            }
        }
        stage('Unit tests') {
            steps {
                script {
                    sh 'mvn clean test'  
                    }
            }
        }
         stage('Deployment TO NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
            }
        }
           stage('Docker Image') {
            steps {
                sh 'sudo docker build -t nourmakdouli-5twin4-g1 .'
            }
        }
        stage('Push Docker Image') {
            steps {
                  sh "sudo docker login -u nourmakdouli -p 92755192nour"
                 sh "sudo docker tag nourmakdouli-5twin4-g1 nourmakdouli/nourmakdouli-5twin4-g1:v1"
                 sh "sudo docker push  nourmakdouli/nourmakdouli-5twin4-g1:v2"
            }
        }
         stage('Docker Compose') {
            steps {
                sh 'sudo docker compose up -d'
            }
        }


     }
}

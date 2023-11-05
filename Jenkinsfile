pipeline {
    agent any // Utilisez n'importe quel agent Jenkins disponible

    stages {
        stage('Git') {
            steps {
                // Récupérer le code source depuis le référentiel Git
                // Checkout the specific branch
                    git branch: 'AcilFarhat-5TWIN4-G1',
                    url: 'https://github.com/SarraTounsi/5TWIN4-G1-kadeem'

            }
        }

        stage('mvn_clean') {
            steps {
                script {
                    // Afficher la date système
                    sh 'mvn clean'       }
            }
        }
        stage('mvn_compile') {
            steps {
                script {
                    // Afficher la date système
                   sh 'mvn compile'      }
            }
        }
        stage('MVN SONARQUBE') {
                steps {
                    script {
                        // Afficher la date système
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
        stage('Docker Image') {
            steps {
                sh 'sudo docker build -t acilfarhat-5twin4-g1 .'
            }
        }  
        stage('dockerhub') {
            steps {

                 sh 'echo "acilfarhat0909" | sudo docker login --username "acilfarhat0909" --password-stdin "acil28500" '
                 sh "sudo docker tag acilfarhat-5twin4-g1 acilfarhat0909/acilfarhat-5twin4-g1:v1"
                 sh "sudo docker push  acilfarhat0909/acilfarhat-5twin4-g1:v1"
                 }
                     }  
        stage('Docker Compose') {
            steps {
                sh 'sudo docker compose up -d'
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


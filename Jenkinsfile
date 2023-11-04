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
                        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dmaven.test.skip=true';
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
        stage('MVN DEPLOY TO NEXUS') {
                     steps {
                         sh 'mvn deploy -Dmaven.test.skip=true'
                     }
                 }
        stage('Docker Image') {
                     steps {
                         sh 'docker build -t acilfarhat-5twin4-g3 .'
                     }
                 }
        stage('Docker Image Push') {
                     steps {

                     }
                 }
        stage('Docker Compose') {
                     steps {
                         sh 'docker compose up -d'
                     }
                 }
    }
}


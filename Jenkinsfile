pipeline {
    agent any // Utilisez n'importe quel agent Jenkins disponible

    stages {
        stage('Git') {
            steps {
                // Récupérer le code source depuis le référentiel Git
                // Checkout the specific branch
                    git branch: 'rayenOueslati_5TWIN4_G1',
                        url: 'https://github.com/SarraTounsi/5TWIN4-G1-kadeem'
        
            }
        }

        stage('MVN CLEAN') {
            steps {
                script {
                    // Afficher la date système
                    sh 'mvn clean'       }
            }
        }
          stage('MVN COMPILE') {
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
                        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=rayen -Dmaven.test.skip=true';
                   }
                }
        }
           stage('TEST JUNIT MOCKITO') {
                 steps {
                        script {
                              sh 'mvn test'  // Run Maven tests
                           }
                        }
         }
    }
}

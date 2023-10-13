pipeline {
    agent any // Utilisez n'importe quel agent Jenkins disponible

    stages {
        stage('Git') {
            steps {
                // Récupérer le code source depuis le référentiel Git
                git checkout : 'rayenOueslati_5TWIN4_G1' ,
                url :'https://github.com/SarraTounsi/5TWIN4-G1-kadeem'
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
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dmaven.test.skip=true';
            }
        }
    }
}

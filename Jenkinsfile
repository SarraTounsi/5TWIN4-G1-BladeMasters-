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
         stage('MVN SONARQUBE') {
            steps {
                script {
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=rayen -Dmaven.test.skip=true -Dsonar.branch.name=rayenOueslati_5TWIN4_G1';
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

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
        stage('Unit tests') {
                    steps {
                        script {
                            sh 'mvn clean test'
                            }
                    }
                }
    }
}
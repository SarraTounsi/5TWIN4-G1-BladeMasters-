pipeline {
    agent any // use any agent

    stages {
        stage('Git') {
            steps {
                //get source code from branch
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
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dmaven.test.skip=true';
                }
            }
        }


     }
}

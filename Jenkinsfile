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
        stage('Tests JUnit/Mockito') {
            steps {
                script {
                    sh 'mvn clean test'  // Run Maven tests
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
                sh 'sudo docker build -t nourmakdouli-5twin4-g1 .'
            }
        }
        // stage('Push Docker Image') {
        //     steps {
        //           sh "sudo docker login -u <username> -p <password>"
        //          sh "sudo docker tag nourmakdouli-5twin4-g1 <username>/nourmakdouli-5twin4-g1:<tag>"
        //          sh "sudo docker push  <username>/nourmakdouli-5twin4-g1:<tag>"
        //     }
        // }
         stage('Docker Compose') {
            steps {
                sh 'sudo docker compose up -d'
            }
        }


     }
}

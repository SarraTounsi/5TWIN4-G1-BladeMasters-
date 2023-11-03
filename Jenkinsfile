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
        //  stage('Start Jenkins and MySQL') {
        //     steps {
        //       //  sh "docker network create my-network"
        //         sh "sudo  docker start mysql"
        //     }
        // }
          stage('Build Docker image') {
            steps {
                // sh "mvn -version"
                // sh "mvn clean package -DskipTests"
                // Make the mvnw script executable
                sh 'mvn clean package -DskipTests'
                sh 'sudo docker build -t my-spring-app .'
                sh'docker run --network springboot-mysql --name springboot-mysql-container -p 8089:8089 kadem'

            }
        }

        // stage('Build Docker image') {
        //     steps {
        //         sh "sudo docker build -t kaddem ."
        //     }
        // }

        // stage('Run Docker image in the same network as MySQL') {
        //     steps {
        //           sh'docker run --network springboot-mysql --name springboot-mysql-container -p 8089:8089 kadem'
        //         // sh "sudo docker run -p 8089:8089 kaddem"
        //     }
        // }
         stage('SonarQube Analysis') {
            steps {
                script {
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=rayen -Dmaven.test.skip=true';
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
        // stage('Nexus') {
        //     steps {
        //         script {
        //             sh 'mvn deploy'
        //         }
        //     }
        // }
        // stage('MVN CLEAN') {
        //     steps {
        //         script {
        //             sh 'mvn clean'       }
        //     }
        // }
        // stage('MVN COMPILE') {
        //     steps {
        //         script {
        //            sh 'mvn compile'      }
        //     }
        // }
        
     }
}

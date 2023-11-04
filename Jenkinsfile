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
         stage('Build with Maven') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=rayen '
            }
        }
        stage('MVN TEST JUNIT') {
            steps {
                sh 'mvn test'
            }
        }
        stage('credentials during build') {
            steps {
                sh 'mvn help:effective-settings -DshowPasswords=true'
            }
        }
        stage('MVN DEPLOY TO NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
            }
        }
         stage('Docker Image') {
            steps {
                sh 'docker build -t rayenoueslati-5twin4-g1 .'
            }
        }
        stage('Docker Image Push') {
            steps {
                script {
                    sh 'echo "rayen15" | docker login --username "rayen15" --password-stdin'
                    sh 'docker tag rayenoueslati-5twin4-g1 rayen15/devops:latest'
                    sh 'docker push rayen15/devops:latest'
                }
            }
        }
         stage('Docker Compose') {
            steps {
                sh 'docker compose up -d'
            }
        }
        //  stage('Build project') {
        //     steps {
        //         script {
        //             sh 'mvn clean package -DskipTests'
        //         }
        //     }
        // }
        // stage('Start MySQL') {
        //     steps {
        //         sh "sudo docker start 01cf03972b41"
        //     }
        // }
        //  stage('Docker Image') {
        //     steps {
        //         sh 'sudo docker build -t rayenoueslati-5twin4-g1 .'
        //         sh 'sudo docker run --network springboot-mysql-net --name springboot-mysql-container -d -p 8089:8089 rayenoueslati-5twin4-g1'
        //     }
        // }
        // stage('SonarQube Analysis') {
        //     steps {
        //         script {
        //             sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=rayen -Dmaven.test.skip=true';
        //         }
        //     }
        // }
        // stage('Tests JUnit/Mockito') {
        //     steps {
        //         script {
        //                 sh 'mvn test'  // Run Maven tests
        //             }
        //         }
        //  }
        // stage('MVN DEPLOY TO NEXUS') {
        //     steps {
        //         sh 'mvn deploy -Dmaven.test.skip=true'
        //     }
        // }
       
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
    post {
        success {
            echo 'Build successful'
        }
        failure {
            echo 'fail'
        }
    }
}

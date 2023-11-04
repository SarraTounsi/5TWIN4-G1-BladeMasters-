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
        //  stage('Build project') {
        //     steps {
        //         script {
        //             sh 'mvn clean package -DskipTests'
        //         }
        //     }
        // }
        //  stage('Run docker compose') {
        //     steps {
        //     //    sh "sudo docker run --name mysqldb --network springboot-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=kadem -d mysql"
        //        sh "sudo docker compose up"
        //     }
        // }
         stage('SonarQube Analysis') {
            steps {
                script {
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=rayen -Dmaven.test.skip=true';
                }
            }
        }
        stage('Start MySQL') {
            steps {
                sh "sudo docker start 01cf03972b41"
            }
        }
         stage('Docker Image') {
            steps {
                sh 'docker build -t rayenoueslati-5twin4-g1 .'
                sh'docker run --network springboot-mysql --name springboot-mysql-container -p 8089:8089 rayenoueslati-5twin4-g1'

            }
        }
        stage('Tests JUnit/Mockito') {
            steps {
                script {
                        sh 'mvn test'  // Run Maven tests
                    }
                }
         }
        stage('MVN DEPLOY TO NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
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

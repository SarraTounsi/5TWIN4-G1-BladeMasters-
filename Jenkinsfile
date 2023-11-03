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
         stage('Build project') {
            steps {
                script {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
         stage('Start MySQL container') {
            steps {
            //    sh "sudo docker run --name mysqldb --network springboot-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=kadem -d mysql"
               sh "sudo docker start b092d7e8bda8"
            }
        }
          stage('Build Docker image') {
            steps {
               script {
                  sh 'sudo docker build -t 5TWIN4-G1-BladeMasters- .'
                }
            }
        }
        stage('Run a docker image in a docker container in the same network') {
            steps {
               script {
                  sh 'sudo docker run --network springboot-mysql --name springboot-mysql-container -p 8089:8089 5TWIN4-G1-BladeMasters-'
                }
            }
        }
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

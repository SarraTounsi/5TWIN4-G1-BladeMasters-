pipeline {
    agent any 

    stages {
        stage('Git') {
            steps {
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
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar';
                }
            }
        }
        stage('Mockito Tests') {
            steps {
                sh 'mvn clean test '
            }
            post {
                always {
                    junit(
                        allowEmptyResults: true,
                        testResults: 
                        junit '**/target/surefire-reports/TEST-*.xml'
                    )
                }
            }
        }
        stage('Generate JaCoCo Report') {
            steps {
                script {
                    // Maven JaCoCo report
                    sh 'mvn jacoco:report'
                    
                    // Optionally, you can archive the generated report
                    archiveArtifacts artifacts: 'target/site/jacoco/index.html', allowEmptyArchive: true
                }
            }
        }

         stage('Deployment TO NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
            }
        }
           stage('Docker Image') {
            steps {
                sh 'sudo docker build -t nourmakdouli-5twin4-g1 .'
            }
        }
        stage('Push Docker Image') {
            steps {
                  sh "sudo docker login -u nourmakdouli -p 92755192nour"
                 sh "sudo docker tag nourmakdouli-5twin4-g1 nourmakdouli/nourmakdouli-5twin4-g1:latest"
                 sh "sudo docker push  nourmakdouli/nourmakdouli-5twin4-g1:latest"
            }
        }
         stage('Docker Compose') {
            steps {
                sh 'sudo docker compose up -d --remove-orphans'
            }
        }


     }

         post {
        success {
            echo 'Build successful'
              always {
            // Optionally, you can publish the JaCoCo report as an artifact
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'target/site/jacoco', reportFiles: 'index.html', reportName: 'JaCoCo Code Coverage'])
        }
        }
        failure {
            echo 'fail'
        }
    }
}












  //stage('Unit Tests')    Nour add profile to pom.xml if you want to use this
                    // {
                       //   steps
                        //  {
                    //          sh 'mvn clean test -Pmockito-tests'
                      //    }
                //                post {
                //                 always {
                //                      junit 'target/surefire-reports/**/*.xml'
                //               }
                //      }
                 //     }
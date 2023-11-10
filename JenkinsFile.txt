pipeline {
    agent any

    stages {
        stage('Git') {
            steps {
                    git branch: 'EmnaTaalouch_5twin4_G1',
                        url: 'https://github.com/SarraTounsi/5TWIN4-G1-kadeem'
            }
        }

        stage('Clean') {
            steps {
                script {
                    sh 'mvn clean'
                }
            }
        }

        stage('Compile') {
            steps {
                script {
                    sh 'mvn compile'
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                script {
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar';
                }
            }
        }
        
        stage('Run JUNIT Tests') {
            steps {
                script {
                    sh 'mvn clean test'
                }
            }
        }
        
        stage('DEPLOY TO NEXUS') {
            steps {
                script {
                    sh 'mvn clean deploy -Dmaven.test.skip=true -DaltDeploymentRepository=releases::default::http://192.168.33.10:8081/repository/maven-releases'
                }
            }
        }

        
    }
}

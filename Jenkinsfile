pipeline{
    agent any
    stages{
        stage('Package Backend'){
            steps{
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage('Unit Tests'){
            steps{
                bat 'mvn test'
            }
        }
         stage('Deploy Backend')
        {
            steps{
                deploy adapters: [tomcat9(credentialsId: 'LoginTomcat', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }
        stage('Api Test')
        {
            steps{
                dir('api-test'){
                    git branch: 'main', url: 'https://github.com/GustavoTC123/task-api-test.git'
                    bat 'mvn test'
                }
            }
        }
        stage('Deploy Frontend')
        {
            steps{
                dir('tasks-frontend'){
                    git branch: 'master', url: 'https://github.com/GustavoTC123/tasks-frontend.git'
                    bat 'mvn package'
                    deploy adapters: [tomcat9(credentialsId: 'LoginTomcat', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks', war: 'target/tasks.war'
                }
            }
        }
        stage('Functional Test')
        {
            steps{
                dir('functional-test'){
                    git branch: 'main', url: 'https://github.com/GustavoTC123/tasks-functional-tests.git'
                    bat 'mvn test'
                }
            }
        }
        stage('Deploy Prod'){
            steps{
                bat 'docker-compose build'
                bat 'docker-compose up -d'
            }
        }
    }
    post{
        always{
            junit allowEmptyResults: true, keepTestNames: true, stdioRetention: '', testResults: '/target/surefire-reports/*.xml', 'functional-test/targetsurefire-reports/*.xml', 'api-test/targetsurefire-reports/*.xml'
        }
    }
}

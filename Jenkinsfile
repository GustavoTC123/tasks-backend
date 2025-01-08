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
    }
}

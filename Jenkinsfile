pipeline{
    agent any
    stages{
        stage('Deploy Backend'){
            steps{
                bat 'mvn clean package -DskipTests=true'
            }
            steps{
                bat 'mvn test'
            }
        }
    }
}
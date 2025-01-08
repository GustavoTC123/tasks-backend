pipeline{
    agent any
    stages{
        stage('Teste'){
            steps{
                bat 'mvn clean package -DskipTests=true'
            }
            steps{
                bat 'mvn test'
            }
        }
    }
}
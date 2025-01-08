pipeline{
    agent any
    stages{
        stage('Teste'){
            steps{
                bat 'mvn clean package -DskipTests=true'
            }
        }
    }
}
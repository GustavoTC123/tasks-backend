pipeline{
    agent any
    environment {
        JAVA_HOME = tool 'JAVA_LOCAL', type: 'JDK'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }
    stages{
        stage('Deploy Backend'){
            steps{
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage('Unit Tests'){
            steps{
                bat 'mvn test'
            }
        }
        stage('Sonar Analysis'){
            environment{
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps{
                withSonarQubeEnv('SONAR_LOCAL'){
                    bat "\"${scannerHome}/bin/sonar-scanner\" -X -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=7645d59a1901eef2e0643bfa61f10d6f8537d79d -Dsonar.java.binaries=target"
                }
            }
        }
        stage('Quality Gate'){
            steps{
                sleep(10)
                timeout(time: 1, unit: 'MINUTES'){
                    waitForQualityGate abortPipeline: true
                }
            }
        }

    }
}
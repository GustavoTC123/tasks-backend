pipeline{
    agent any
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
        stage('Sona Analyisis'){
            environment{
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps{
                withSonarCubeEnv('SONAR_LOCAL'){
                    bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=7645d59a1901eef2e0643bfa61f10d6f8537d79d -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**, **/src/test/**, **/model/**, **Application.java, **RootController.java"
                }
            }
        }
    }
}
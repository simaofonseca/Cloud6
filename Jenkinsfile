pipeline
{
	agent any

	parameters
	{
		string(name: 'DOCKER_IMAGE', defaultValue: 'default_name', description: 'Docker image')

	}

    stages
    { 
        stage('Docker build'){
            steps
            {
		sh "docker rmi -f ${DOCKER_IMAGE}"
		sh "docker build -t ${DOCKER_IMAGE} ."
	    }
        }
	stage('Nexus'){
	    steps
                sh "docker login -u admin -p admin localhost:8082 "
		sh "docker tag ${DOCKER_IMAGE} localhost:8082/${DOCKER_IMAGE}"
		sh "docker push localhost:8082/${DOCKER_IMAGE}"
                sh "javac *.java"
                sh "jar cfe calculator.jar Calculadora2 ./*.class"
                sh "curl -v -u 'admin:admin' --upload calculator.jar http://nexus:8081/repository/my-raw/"

            }
        }
	stage("Sonarqube") {
            environment { scannerHome = tool 'sonarqube' }
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner \
                    -D sonar.login=a71522f0b9f9d3ddebf155f41e5ce23561b4c222 \
                    -D sonar.projectKey=sonarqube \
                    -D sonar.java.binaries=/var/jenkins_home/workspace/Sonarqube \
                    -D sonar.java.source=11 \
                    -D sonar.host.url=http://sonarqube:9000/"
                    }
                }
            }	
    }
}
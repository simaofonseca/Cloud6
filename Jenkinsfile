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
                sh "docker login -u simaofonseca -p aluno1234567 localhost:8082 "
				sh "docker tag ${DOCKER_IMAGE} localhost:8082/${DOCKER_IMAGE}"
				sh "docker push localhost:8082/${DOCKER_IMAGE}"
                sh "javac *.java"
                sh "jar cfe calculator.jar Calculadora2 ./*.class"
                sh "curl -v -u 'admin:admin' --upload calculator.jar http://nexus:8081/repository/java-calc/"

            }
        }
		

		

    }
}

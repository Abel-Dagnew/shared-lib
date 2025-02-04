def buildPushDockerImage(ACR_NAME, DOCKER_IMAGE_NAME, ACR_LOGIN_SERVER) {
    stage('Build Docker Image') {
        steps {
            script {
                // Build Docker image
                sh "docker build -t ${ACR_NAME}/${DOCKER_IMAGE_NAME}:latest ."
            }
        }
    }

    stage('List Docker Images') {
        steps {
            script {
                // List Docker images to verify the image tag exists
                sh 'docker images'
            }
        }
    }

    stage('Tag Docker Image') {
        steps {
            script {
                // Tag the Docker image for Azure Container Registry
                sh "docker tag ${ACR_NAME}/${DOCKER_IMAGE_NAME}:latest ${ACR_LOGIN_SERVER}/${DOCKER_IMAGE_NAME}:latest"
            }
        }
    }

    stage('Push Docker Image to ACR') {
        steps {
            script {
                // Push the Docker image to Azure Container Registry
                sh '''
                    docker push ${ACR_LOGIN_SERVER}/${DOCKER_IMAGE_NAME}:latest
                '''
            }
        }
    }
}

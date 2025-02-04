// vars/BuildPushDockerImage.groovy
def call(ACR_NAME, DOCKER_IMAGE_NAME, ACR_LOGIN_SERVER) {
    // This function will contain only the logic, and stages will be called from the pipeline
    return {
                script {
                    // Build Docker image
                    sh "docker build -t ${ACR_NAME}/${DOCKER_IMAGE_NAME}:latest ."
                    // List Docker images to verify the image tag exists
                    sh 'docker images'
                    // Tag the Docker image for Azure Container Registry
                    sh "docker tag ${ACR_NAME}/${DOCKER_IMAGE_NAME}:latest ${ACR_LOGIN_SERVER}/${DOCKER_IMAGE_NAME}:latest"
                    // Push the Docker image to Azure Container Registry
                    sh "docker push ${ACR_LOGIN_SERVER}/${DOCKER_IMAGE_NAME}:latest"
                }
        
    }
}
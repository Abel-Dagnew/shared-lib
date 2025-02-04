def call() {
    script {
                    // Configure Azure Web App to use the latest image from ACR
                    sh '''
                        az webapp config container set --name ${AZURE_WEB_APP_NAME} \
                        --resource-group ${AZURE_RESOURCE_GROUP} \
                        --docker-custom-image-name ${ACR_LOGIN_SERVER}/${DOCKER_IMAGE_NAME}:latest \
                        --docker-registry-server-url https://${ACR_LOGIN_SERVER} \
                        --docker-registry-server-user ${ACR_USERNAME} \
                        --docker-registry-server-password ${ACR_PASSWORD}
                    '''
                }
}
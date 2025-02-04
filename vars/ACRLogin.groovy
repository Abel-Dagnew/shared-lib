def call(){

    script {
                    // Log in to Azure Container Registry using username and password
                    sh '''
                        echo ${ACR_PASSWORD} | docker login ${ACR_LOGIN_SERVER} --username ${ACR_USERNAME} --password-stdin
                    '''
                }
}
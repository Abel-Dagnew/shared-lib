// vars/azureLogin.groovy
def azureLogin1() {
    script {
        withCredentials([ 
            string(credentialsId: 'ARM_CLIENT_ID', variable: 'AZURE_CLIENT_ID'),
            string(credentialsId: 'ARM_CLIENT_SECRET', variable: 'AZURE_CLIENT_SECRET'),
            string(credentialsId: 'ARM_TENANT_ID', variable: 'AZURE_TENANT_ID'),
            string(credentialsId: 'ARM_SUBSCRIPTION_ID', variable: 'AZURE_SUBSCRIPTION_ID')
        ]) {
            // Logging in to Azure using Service Principal
            sh '''
                az login --service-principal -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET --tenant $AZURE_TENANT_ID
                az account set --subscription $AZURE_SUBSCRIPTION_ID
            '''
        }
    }
}

def DeployToAKS() {

    script {
                    // Use kubeconfig from Jenkins credentials
                    withCredentials([ 
                        string(credentialsId: 'ARM_CLIENT_ID', variable: 'AZURE_CLIENT_ID'),
                        string(credentialsId: 'ARM_CLIENT_SECRET', variable: 'AZURE_CLIENT_SECRET'),
                        string(credentialsId: 'ARM_TENANT_ID', variable: 'AZURE_TENANT_ID'),
                        string(credentialsId: 'ARM_SUBSCRIPTION_ID', variable: 'AZURE_SUBSCRIPTION_ID')
                    ]) {
                        sh '''
                            az login --service-principal -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET --tenant $AZURE_TENANT_ID
                            az aks get-credentials --resource-group Abel-AKS-rg --name My-AKS-00 --admin
                            kubectl apply -f kubernetes/deployment.yaml
                            kubectl apply -f kubernetes/service.yaml

                        '''
}

                }
}
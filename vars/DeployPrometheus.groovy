def call(NAMESPACE) {
    script {
                    // Deploy Prometheus using Helm
                    sh '''
                        helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
                        helm repo update
                        helm upgrade --install prometheus prometheus-community/prometheus --namespace ${NAMESPACE} -f kubernetes/prometheus-values.yaml
                    '''
                }
}
def call() {

    script {
                    // Deploy Grafana using Helm
                    sh '''
                        helm repo add grafana https://grafana.github.io/helm-charts
                        helm repo update
                        helm upgrade --install grafana grafana/grafana --namespace ${NAMESPACE} -f kubernetes/grafana-values.yaml
                    '''
                }
}
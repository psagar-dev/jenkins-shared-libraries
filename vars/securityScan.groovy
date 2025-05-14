def call() {
    parallel(
        'Trivy Vulnerability Scan': {
            sh '''
                docker run --rm \
                -v $PWD:/project \
                aquasec/trivy:latest fs /project \
                --exit-code 1 --severity HIGH,CRITICAL || true
            '''
        },
        'Gitleaks Secret Scan': {
            sh '''
                docker run --rm \
                -v $PWD:/repo \
                zricethezav/gitleaks:latest detect \
                --source=/repo --verbose --redact --exit-code 1 || true
            '''
        }
    )
}

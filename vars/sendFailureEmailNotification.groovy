def call(String recipients) {
    if (!recipients?.trim()) {
        echo "No recipients specified for failure notification."
        return
    }

    emailext(
        subject: "❌ FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        body: "Build failed!\n\nCheck console: ${env.BUILD_URL}",
        to: recipients
    )
}

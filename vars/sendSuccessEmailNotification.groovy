def call(String recipients) {
    if (!recipients?.trim()) {
        echo "No recipients specified for success notification."
        return
    }

    emailext(
        subject: "✅ SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        body: "Build passed!\n\nDetails: ${env.BUILD_URL}",
        to: recipients
    )
}

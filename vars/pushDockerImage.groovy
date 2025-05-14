def call(String dockerImage, String dockerCredentialsId) {
    docker.withRegistry('', dockerCredentialsId) {
        docker.image(dockerImage).push()
    }
}

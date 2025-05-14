def call(String dockerImage = 'securelooper/flask-cicd:latest', String dockerContainerName = "flask-cicd-container", String DockerCredentalsId = "docker-hub-creds") {
    return [
        DOCKER_IMAGE: ${dockerImage},
        CONTAINER_NAME: ${dockerContainerName},
        DOCKER_CREDENTIALS_ID: ${DockerCredentalsId}
    ]
}

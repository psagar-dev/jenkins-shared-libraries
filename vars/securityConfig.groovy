def call(String dockerImage = 'securelooper/flask-cicd',String containerName = "flask-cicd-container") {
    return [
        DOCKER_IMAGE: ${dockerImage},
        CONTAINER_NAME: ${dockerImage},
        DOCKER_CREDENTIALS_ID: 'docker-hub-creds'
    ]
}

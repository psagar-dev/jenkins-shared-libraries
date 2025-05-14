def call(String dockerImage, String dockerContainerName, String ec2User, String ec2Host, String ports = "80:80", String sshId = "ssh-ec2") {
    sshagent(credentials: ["${sshId}"]) {
        sh """
            ssh -o StrictHostKeyChecking=no ${ec2User}@${ec2Host} '
            echo "Pulling latest Docker image"
            sudo docker pull ${dockerImage}

            echo "Stopping any existing container..."
            sudo docker stop ${dockerContainerName} || true
            sudo docker rm ${dockerContainerName} || true

            echo "Running the container..."
            sudo docker run -d --name ${dockerContainerName} -p ${ports} ${dockerImage}

            echo "Deployment successful!"
            '
        """
    }
}

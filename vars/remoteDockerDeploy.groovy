def call(String dockerImage, String dockerContainerName, String ports = "80:80", String sshId = "ssh-ec2") {
    sshagent(credentials: ["${sshId}"]) {
        sh """
            ssh -o StrictHostKeyChecking=no ${env.FLASK_CICD_EC2_USER}@${FLASK_CICD_EC2_HOST} '
            sudo docker pull ${dockerImage}

            sudo docker stop ${dockerContainerName} || true
            sudo docker rm ${dockerContainerName} || true
            sudo docker run -d --name ${dockerContainerName} -p ${ports} ${dockerImage}
            '
        """
    }
}

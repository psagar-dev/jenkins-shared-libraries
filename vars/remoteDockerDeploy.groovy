def call(String dockerImage, String dockerContainerName, String ec2User, String ec2Host, String ports = "80:80", String sshId = "ssh-ec2") {
    sshagent(credentials: ["${sshId}"]) {
        sh """
            ssh -o StrictHostKeyChecking=no ${ec2User}@${ec2Host} '
            sudo docker pull ${dockerImage}

            sudo docker stop ${dockerContainerName} || true
            sudo docker rm ${dockerContainerName} || true
            sudo docker run -d --name ${dockerContainerName} -p ${ports} ${dockerImage}
            '
        """
    }
}

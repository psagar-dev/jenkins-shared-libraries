def call(String venvDir = 'venv', String requirements = 'requirements.txt') {
    sh """
        python3 -m venv ${venvDir}
        ./${venvDir}/bin/pip install --upgrade pip
        ./${venvDir}/bin/pip install -r ${requirements}
    """
}

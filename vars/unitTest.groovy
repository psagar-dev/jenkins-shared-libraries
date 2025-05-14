def call(String venvDir = 'venv', String requirements = 'requirements.txt') {
    sh """
        ./${venvDir}/bin/python -m pytest tests
    """
}

def call(String venvDir = 'venv') {
    sh """
        ./${venvDir}/bin/python -m pytest tests
    """
}

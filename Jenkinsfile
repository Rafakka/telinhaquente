pipeline {
    agent any

    stages {

        stage('Buildar containers') {
            steps {
                sh 'docker compose down || true'
                sh 'docker compose build'
            }
        }

        stage('Subir containers') {
            steps {
                sh 'docker compose up -d'
            }
        }
    }

    post {
        success {
            echo 'Aplicação em execução via Docker com sucesso!'
        }
        failure {
            echo 'Algo deu errado durante o pipeline.'
        }
    }
}

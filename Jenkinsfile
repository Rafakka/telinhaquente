pipeline {
    agent any

    stages {
        stage('Clonar código') {
            steps {
                git 'https://github.com/Rafakka/telinhaquente'
            }
        }

        stage('Buildar containers') {
            steps {
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

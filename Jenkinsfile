pipeline {
    agent any

    stages {

    stage('Resetar ambiente') {
    steps {
        echo 'Derrubando containers antigos'
        sh 'docker compose down || true'
    }
    }

    stage('Buildar e subir containers') {
    steps {
        echo 'Buildando e subindo containers'
        sh 'docker compose up -d --build'
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

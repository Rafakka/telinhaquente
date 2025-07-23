pipeline {
    agent any

    stages {
        stage ('Clonar codigo'){
            steps {
                git'https://github.com/Rafakka/telinhaquente.git'
            }
        }
        stage('Buildar Containers'){
            steps {
                sh 'docker compose build'
            }
        }
        stage ('Subir Containers') {
            steps {
                sh 'docker compose up -d'
            }
        }
    }

    post {
        sucess {
            echo 'Aplicação em execucação via Docker com sucesso!'
        }
        failure {
            echo 'Algo deu errado durante o pipeline'
        }

    }

}

node {
    def app

    stage('Checkout') {
        checkout scm
    }
	
    stage('Maven Package') {
        sh 'mvn clean package'
    }

    stage('Build image') {
        app = docker.build("learntechpuzz/demo-calculator-service")
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}


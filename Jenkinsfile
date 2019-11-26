node {
    def app

    tools {
        maven 'maven-3.6.2'
        jdk 'openjdk-1.8'
    }

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


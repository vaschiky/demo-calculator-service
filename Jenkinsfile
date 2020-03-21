node {
    def app

    stage('Checkout') {
        checkout scm
    }
	
    stage('Maven Package') {
        withMaven(maven:'maven-3.6.3'){
          sh 'mvn clean package'
	}
    }

    stage('Build Image') {
        app = docker.build("learntechpuzz/demo-calculator-service:${env.BUILD_NUMBER}")
    }

    stage('Push Image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
        }
    }
    stage('Deploy Container'){
    	docker.withServer('tcp://54.175.228.93:2376') {
	         app.withRun('-p 7001:7001') {
	        }
    	}
    }
}


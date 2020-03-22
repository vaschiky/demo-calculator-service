node {
    def app

	def remote = [:]
    remote.name = 'prod-server'
    remote.host = '54.175.228.93'
    remote.user = 'ec2-user'
    remote.password = 'India@321'
    remote.allowAnyHosts = true
    
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
 		writeFile file: 'deploy.sh', text: "docker run -d -p 7001:7001 learntechpuzz/demo-calculator-service:$BUILD_NUMBER"
      	sshScript remote: remote, script: "deploy.sh"   
    }
    
    stage('Send Email') {
	    def mailRecipients = "learntechpuzz@gmail.com"

	    emailext body: '''${SCRIPT, template="groovy-html.template"}''',
	        mimeType: 'text/html',
	        to: "${mailRecipients}"
	}
}


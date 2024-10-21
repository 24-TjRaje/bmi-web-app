pipeline {
    agent any

    environment {
        IMAGE_NAME = 'bmi-calculator'
        BRANCH_NAME = 'develop'
        CONTAINER_NAME = 'bmi-app'
        DOCKER_CREDS = credentials('docker-creds')
    }

    stages {

        stage('Building the code') {

            steps {
                sh 'mvn clean install'
            }

        }
        stage('Creating and pushing docker image') {

            steps {
                sh 'docker build -t ${IMAGE_NAME}:${BUILD_NUMBER} .'
                sh 'docker tag ${IMAGE_NAME}:${BUILD_NUMBER} $DOCKER_CREDS_USR/${IMAGE_NAME}:${BUILD_NUMBER}'
                sh 'docker login -u $DOCKER_CREDS_USR --password $DOCKER_CREDS_PSW'
                sh 'docker push $DOCKER_CREDS_USR/${IMAGE_NAME}:${BUILD_NUMBER}'
            }

        }
        stage('Running the container') {

            steps {
                sh 'docker stop ${CONTAINER_NAME} || true && docker rm ${CONTAINER_NAME} || true'
                sh 'docker pull $DOCKER_CREDS_USR/${IMAGE_NAME}:${BUILD_NUMBER}'
                sh 'docker run --name ${CONTAINER_NAME} -d -p 82:8083 $DOCKER_CREDS_USR/${IMAGE_NAME}:${BUILD_NUMBER}'
            }
        }
    }

    post {
        success {
            sh 'echo "Job ${JOB_NAME} completed successfully for build number ${BUILD_NUMBER}."'
        }
        failure {
            sh 'echo "Job ${JOB_NAME} failed for build number ${BUILD_NUMBER}."'
        }

    }
}
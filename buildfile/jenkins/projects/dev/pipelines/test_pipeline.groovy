//https://stackoverflow.com/questions/35898020/job-dsl-to-create-pipeline-type-job
pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                echo 'executing stage1'
            }
        }
        stage('Stage 2') {
            steps {
                echo 'executing stage2'
            }
        }
    }
}


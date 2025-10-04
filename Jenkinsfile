pipeline {
    agent any


    stages {
        stage('第一步： 拉取代码') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'acc230f9-921a-4875-b49e-f458edc419d9', url: 'git@github.com:nds13755/demo1.git']])
            }
        }

        stage('第二步： 编译构建') {
            steps {
                sh '/usr/local/apache-maven-3.9.11/bin/mvn clean package'
            }
        }

        stage('第三步： 发布项目') {
            steps {
                deploy adapters: [tomcat9(credentialsId: '625ca5bd-6dbd-4305-a488-3b319fd5e71c', path: '', url: 'http://47.108.72.218:8111/')], contextPath: null, war: 'target/*.war'
            }
        }
    }

    post {
            always {
                emailext(
                    subject: '构建通知：${PROJECT_NAME} - Build # ${BUILD_NUMBER} - ${BUILD_STATUS}!',
                    body: '${FILE,path="email.html"}',
                    to: 'nds13755@126.com,352599751@qq.com'
                )
            }
     }

}

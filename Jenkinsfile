timestamps {

  node("HybrisQAVM01") {
    ansiColor('xterm') {
      withEnv(["JAVA_HOME=${tool 'jdk8'}", "PATH+MAVEN=${tool 'maven'}/bin:${env.JAVA_HOME}/bin"]) {
      
        stage('Build') {
          if(isUnix()) {
            sh "mvn clean package"
          } else {
            bat "mvn clean package"
            }
          }
          
          stage('Execute Tests") {
            try {
                if(isUnix()) {
                sh """
                %JAVA_HOME%/bin/java -jar target/iccs-1.0-SNAPSHOT.jar
                """
               } else {
                bat """
                %JAVA_HOME%\\bin\\java -jar target\\iccs-1.0-SNAPSHOT.jar
                """
                }
               } finally {
                  allure includeProperties: false, jdk: '', results [[path: 'target/results']]
               }
             }
           }
         }
       }
     }
                  

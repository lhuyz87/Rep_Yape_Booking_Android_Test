import java.text.SimpleDateFormat

currentBuild.displayName="Canal APP-Android-#"+currentBuild.number
def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()
String nombreProyecto=""
def props =""


pipeline {

    agent any
    
    tools {
        maven 'M3'
        jdk 'jdk8.221'
    }
    
    options {
		buildDiscarder(logRotator(numToKeepStr: '20'))
	    disableConcurrentBuilds()
	}
    
    stages {
    
	
        stage ('Build') {
            steps {
            	//echo "name_project=${name_project}"
                bat ("mvn -X clean verify")
            }
        }
        
        stage('Ejecutar Pruebas'){
            steps{
                
        			script {
	        			try {
	        				//sh ("mvn verify package -P Rimac")
					          bat ("mvn test -Dcucumber.features=src/test/resources/features/ -Dcucumber.filter.tags=${ESCENARIO} -Dcucumber.plugin=json:target/site/result.json -Dcucumber.glue=rimac.main.definition")  
	        				bat ("mvn serenity:aggregate")
	        				echo 'Ejecucion de pruebas sin errores...'
	        			}
	        			catch (ex) {
	        				echo 'Finalizo ejecucion con fallos...'
	        				error ('Failed')
	                    }
                    }
                }
            }
                   
        stage ('Reporte') {
        	steps {
        		script {
                     try {
                    	checkout scm
                    	props = readProperties  file:'serenity3.properties'
					    nombreProyecto= props['serenity.project.name']
					    echo "EL nombre de proyecto es $nombreProyecto"
                    	bat ("echo ${defTimestamp}")
                    	publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                        echo 'Reporte realizado con exito'
                    }

                    catch (ex) {
                        echo 'Reporte realizado con Fallos'
                        error ('Failed')
                    }
                }
            }
            
            post {                
                       always {                  
                         echo "Se envía correo de resultados"
                         //echo "Send notifications for result: ${currentBuild.result}"                  
                         mail to: "luis.retamozoa@rimac.com.pe",
                         subject: "$nombreProyecto-${currentBuild.result} Ejec-#: ${currentBuild.number}",
                         body: "${currentBuild.currentResult}: ${ESCENARIO}\nMore Info can be found here: \n ${env.BUILD_URL}Evidencias_20de_20Prueba/"                    
                        }
               }       
        }
    }
}
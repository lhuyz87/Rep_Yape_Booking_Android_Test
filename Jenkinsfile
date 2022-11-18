import java.text.SimpleDateFormat

currentBuild.displayName="Canal APP-Android-#"+currentBuild.number
def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()
String nombreProyecto=""
String nombreProyecto2=""
def props =""
def props2 =""
//Properties props = new Properties()
Properties properties = new Properties()
File propertiesFile = new File('serenity.properties')

def getProps(path) {
    Properties props = new Properties()
    props.load(new FileInputStream(file(path)))
    return props
}

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
                    	props = readProperties  file:'serenity.properties'
					    nombreProyecto= props['${WORKSPACE}/serenity.project.name']
					    
					    propertiesFile.withInputStream {
   						properties.load(it)
						}
						
						nombreProyecto2 =properties.serenity.project.name
					    
					    echo "EL nombre de proyecto es $nombreProyecto2"
                    	bat ("echo ${defTimestamp}")
                    	publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                        echo 'Reporte realizado con exito'
                    }

                    catch (Exception e) {
                        echo 'Reporte realizado con Fallos'
                        print "Error cause: ${e}"
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
import java.text.SimpleDateFormat

//currentBuild.displayName="Canal APP-Android-#"+currentBuild.number
def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()
String nombreProyecto=""
String nombreProyecto2=""
def props =""
def props2 =""
String aux =""
//Properties props = new Properties()
//Properties properties = new Properties()
//File propertiesFile = new File('${WORKSPACE}/serenity.properties')
File propertiesFile = null

def loadProperties() {
    node {
        checkout scm
        properties = new Properties()
        File propertiesFile = new File("${workspace}/serenity.properties")
        properties.load(propertiesFile.newDataInputStream())
        //echo "Immediate one ${properties.repo}"
    }
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
					        sh ("mvn test -Dcucumber.features=src/test/resources/features/ -Dcucumber.filter.tags=\'${ESCENARIO}\' -Dcucumber.plugin=json:target/site/result.json -Dcucumber.glue=rimac")
	        				sh ("mvn serenity:aggregate")
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
                    	/*checkout scm
                    	props = readProperties  file:'serenity.properties'
					    nombreProyecto= props['serenity.project.name']
					    aux = "${WORKSPACE}\\serenity.properties"
					    //InputStream instream = new FileInputStream(aux);
					    echo "Ruta  es $aux"
					    
					     loadProperties()
                    	 echo "Later one1 ${properties.name}"
                    	// echo "Later one2${properties.serenity.project.name}"
					    
   						//properties.load(propertiesFile)
						
						
						//nombreProyecto2 =props2.getProperty("serenity.project.name");
					    
					    //echo "EL nombre de proyecto es $nombreProyecto2"
                    	bat ("echo ${defTimestamp}")
                    	publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                        echo 'Reporte realizado con exito'*/

                        sh ("mvn serenity:aggregate")
                        	        			echo 'Ejecucion de pruebas sin errores...'
                                            	//bat ("echo ${WORKSPACE}")
                                            	sh ("echo ${defTimestamp}")
                                            	publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                                            	//publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}/target/site/serenity${defTimestamp}", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: ''])
                                            	//publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}\\target\\site\\serenity${defTimestamp}", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: ''])
                                                echo 'Reporte realizado con exito'
                    }

                    catch (Exception e) {
                        echo 'Reporte realizado con Fallos'
                        print "Error cause: ${e}"
                        error ('Failed')
                    }
                }
            }
            /*
            post {                
                       always {                  
                         echo "Se envía correo de resultados"
                         //echo "Send notifications for result: ${currentBuild.result}"                  
                         mail to: "luis.retamozoa@rimac.com.pe",
                         subject: "${properties.name}-${currentBuild.result} Ejec-#: ${currentBuild.number}",
                         //subject: "$nombreProyecto-${currentBuild.result} Ejec-#: ${currentBuild.number}",
                         
                         body: "${currentBuild.currentResult}: ${ESCENARIO}\nMore Info can be found here: \n ${env.BUILD_URL}Evidencias_20de_20Prueba/"                    
                        }
               }  */
        }
    }
}
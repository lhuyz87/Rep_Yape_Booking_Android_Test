import java.text.SimpleDateFormat

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()
currentBuild.displayName="API-Automation-#"+currentBuild.number
//def secrets = [
//  [path: 'AutoRimac/AppNativa-auto-def-iOS', engineVersion: 2, secretValues: [
//  	    [envVar: 'v_appiumUdidIOS', vaultKey: 'v_appiumUdidIOS'],
//	    [envVar: 'v_appiumXcodeOrgId', vaultKey: 'v_appiumXcodeOrgId'],
//	    [envVar: 'v_appiumXcodeSigningId', vaultKey: 'v_appiumXcodeSigningId'],
//	    [envVar: 'DniUser', vaultKey: 'DniUser'],
//	    [envVar: 'PassUser', vaultKey: 'PassUser']
// 	]
//  ]
//]

//def configuration = [vaultUrl: 'http://localhost:8200',  vaultCredentialId: 'VaultCredential', engineVersion: 2]
def workspace = pwd()
def path = "${WORKSPACE}" + "/"
echo 'Reporte realizado con Fallos'
echo workspace
echo path
def props = readProperties  file:'${env.WORKSPACE}/serenity.properties'
def name_project= props['*/serenity.project.name']
//def Var2= props['Tuesday']



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
            	echo "name_project=${name_project}"
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
                    	//bat ("echo ${WORKSPACE}")
                    	bat ("echo ${defTimestamp}")
                    	publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                    	//publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}/target/site/serenity${defTimestamp}", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: ''])
                    	//publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}\\target\\site\\serenity${defTimestamp}", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: ''])
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
                         echo "Enviar correo"
                         echo "Send notifications for result: ${currentBuild.result}"                  
                         mail to: "luis.retamozoa@rimac.com.pe",
                         subject: "${currentBuild.result} Pipeline: ${currentBuild.fullDisplayName}",
                         body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: \n ${env.BUILD_URL}Evidencias_20de_20Prueba/"                    
                        }
               }       
        }
    }
}
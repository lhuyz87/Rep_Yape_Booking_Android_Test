import java.text.SimpleDateFormat

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()

def secrets = [
  [path: 'AutoRimac/AppNativa-auto-def-iOS', engineVersion: 2, secretValues: [
  	    [envVar: 'v_appiumUdidIOS', vaultKey: 'v_appiumUdidIOS'],
	    [envVar: 'v_appiumXcodeOrgId', vaultKey: 'v_appiumXcodeOrgId'],
	    [envVar: 'v_appiumXcodeSigningId', vaultKey: 'v_appiumXcodeSigningId'],
	    [envVar: 'DniUser', vaultKey: 'DniUser'],
	    [envVar: 'PassUser', vaultKey: 'PassUser']
 	]
  ]
]

def configuration = [vaultUrl: 'http://localhost:8200',  vaultCredentialId: 'VaultCredential', engineVersion: 2]

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
                sh ("mvn -X clean verify")
            }
        }
        
        stage('Ejecutar Pruebas'){
            steps{
                withVault([configuration: configuration, vaultSecrets: secrets]) {
        			script {
	        			try {
	        				//sh ("mvn verify package -P Rimac")
	        				sh ("mvn test -Dcucumber.options=\"src/test/resources/features/ --tags \'${ESCENARIO}\' --plugin json:target/site/result.json --glue rimac\" -P Rimac")
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
        }
            
        stage ('Reporte') {
        	steps {
        		script {
                     try {
                    	//bat ("echo ${WORKSPACE}")
                    	sh ("echo ${defTimestamp}")
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
        }
    }
}
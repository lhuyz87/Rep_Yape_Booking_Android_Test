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
File propertiesFile = null

def secrets = [
  [path: 'AutoRimac/CanalApp-auto-def-Android', engineVersion: 2, secretValues: [
	    [envVar: 'v_appPathActual', vaultKey: 'v_appPathActual'],
	    [envVar: 'v_appPathMinRecomendada', vaultKey: 'v_appPathMinRecomendada'],
	    [envVar: 'v_appPathMinRequerida', vaultKey: 'v_appPathMinRequerida'],
	    [envVar: 'v_SaucelabsUser', vaultKey: 'v_SaucelabsUser'],
	    [envVar: 'v_SaucelabsAccessKey', vaultKey: 'v_SaucelabsAccessKey']
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
            	//echo "name_project=${name_project}"
                sh ("mvn -X clean verify")
            }
        }
        
    stage('Ejecutar Pruebas'){
                steps{
                    withVault([configuration: configuration, vaultSecrets: secrets]) {
            			script {
            				try {
                                sauce('saucelabs-US') {
                                    sauceconnect(useGeneratedTunnelIdentifier: true, verboseLogging: true) {
                                    switch("${ESCENARIO}") {
                                        case "@InstalarApp":
                                            echo 'Se instala App...'
                                            sh ("mvn test -Denvironment=sauce_Android -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags=\'${ESCENARIO}\' -Dcucumber.plugin=json:target/site/result.json -Dcucumber.glue='rimac' -P instalar")
                                            break
                                        case "@ValidaVersionMinimaRequerida":
                                            echo 'Se instala App menor a la versión mínima requerida...'
                                            sh ("mvn test -Denvironment=sauce_Android -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags=\'${ESCENARIO}\' -Dcucumber.plugin=json:target/site/result.json -Dcucumber.glue='rimac' -P verMinRequerida")
                                            break
                                        case "@ValidaVersionMinimaRecomendada":
                                            echo 'Se instala App menor a la versión mínima recomendada...'
                                            sh ("mvn test -Denvironment=sauce_Android -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags=\'${ESCENARIO}\' -Dcucumber.plugin=json:target/site/result.json -Dcucumber.glue='rimac' -P verMinRecomendada")
                                            break
                                        default:
                                            sh ("mvn test -Denvironment=sauce_Android -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags=\'${ESCENARIO}\' -Dcucumber.plugin=json:target/site/result.json -Dcucumber.glue='rimac' -P noInstalar")
                                            break
                                    }

    	        			        }
    	        			    }
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
                	steps  {
                		script {
                                 try {
                                    sh ("mvn serenity:aggregate")
                                    echo 'Ejecucion de pruebas sin errores...'
                                    //bat ("echo ${WORKSPACE}")
                                    sh ("echo ${defTimestamp}")
                                    publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                                    //publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}/target/site/serenity${defTimestamp}", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: ''])
                                    //publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}\\target\\site\\serenity${defTimestamp}", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: ''])
                                    //saucePublisher()
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
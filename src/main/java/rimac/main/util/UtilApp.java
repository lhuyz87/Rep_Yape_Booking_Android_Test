package rimac.main.util;

import java.util.Arrays;

import java.util.List;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.json.JSONObject;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;



import static io.appium.java_client.touch.WaitOptions.waitOptions;

import static io.appium.java_client.touch.offset.PointOption.point;

import io.appium.java_client.AppiumBy;

//import com.gargoylesoftware.htmlunit.WebConsole.Logger;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.findby.By;
//import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rimac.main.util.UtilApp;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilApp  extends BaseDriver{

	public static Properties p;
	private static UtilApp obj = null;
	
	private final static PointerInput FINGER = new PointerInput(TOUCH, "finger");

	
	
	public static UtilApp getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new UtilApp();
		}
	}

	/**
	 * Este método es invocado por Jenkins automáticamente (en caso esté publicado)
	 * @param variable
	 * @return
	 */
	public String getVarEnvPro(String variable) {
		String varEnvPro = "";
		if (System.getProperty("varFlag") != null) {
			varEnvPro = System.getProperty(variable);//desde el properties
		} else {
			varEnvPro = System.getenv(variable); //desde el Vault
		}
		return varEnvPro;
	}

	public void getProperties() {
		try {
			p = new Properties();
			p.load(new FileReader(new File("src/test/resources/secrets.properties")));
			for (String name : p.stringPropertyNames()) {
				String value = p.getProperty(name);
				System.setProperty(name, value);
//		        System.out.println(name +" : " + value);
			}
		} catch (Exception e) {
			System.out.println("Mensaje " + e.getMessage());
		}
	}

	public boolean verificarPDFdescargado(String nom_Documento, int totalTimeoutInMillis) throws InterruptedException  {
		boolean flag = false;
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String pathDescarga = variables.getProperty("chrome_preferences.download.default_directory");
		System.out.println("Ruta referencia: "+pathDescarga);
		String nom_ArchivoDescargado = "";

		/**
		 * Se añade totalTimeoutInMillis, 
		 * representa al tiempo en milisegundos para esperar q termine de descargar y luego poder traer el último archivo
		 */

		Thread.sleep(totalTimeoutInMillis);

		nom_ArchivoDescargado = getNombreUltimoArchivoDescargado(pathDescarga, "pdf", nom_Documento);
		String file_with_location = pathDescarga + nom_ArchivoDescargado;
		System.out.println("nom_ArchivoDescargado: " + nom_ArchivoDescargado);
		System.out.println("file_with_location: " + file_with_location);
		
		File file = new File(file_with_location);
		flag = file.exists();
		System.out.println(flag);
		if (flag)
			System.out.println(" SÍ SE LOGRÓ DESCARGAR EL ARCHIVO: "+ nom_ArchivoDescargado);
		else
			System.out.println(" NO SE LOGRÓ DESCARGAR");
			
		return flag;
		
	}
	
	public String getNombreUltimoArchivoDescargado(String filePath, String extension, String nom_Documento) throws InterruptedException {
		File dir = new File(filePath);
		FileFilter fileFilter = new WildcardFileFilter("*." + extension);
		String nombreDocumentoDescargado = "";
		
		for (File files : dir.listFiles(fileFilter)) {
			if(files.getName().contains(nom_Documento)) {
				nombreDocumentoDescargado = files.getName();
				break;
			}
	    }

		return nombreDocumentoDescargado;
	}
	
	public void esperarElemento(int intentos, WebElement elemento) {
		int contador=0;
		System.out.println("Espera Elemento : "  + elemento.toString());
		Serenity.takeScreenshot();
		while(element(elemento).isEnabled()==false) {
			contador++;
			if(element(elemento).isEnabled()==true||contador==intentos) {
				System.out.println("Se encuentra elemento o contador finalizo");			
				break;
			}else {
				esperarSegundos(1);
				System.out.println("contador: " + contador + elemento);
			}
				
		}
	}

	public void scrolHastaElemento(int intentos, WebElement elemento) {

		int contador=0;
		Serenity.takeScreenshot();
		while(element(elemento).isCurrentlyVisible()==false) {
			mobileSwipeScreenAndroid();
			contador++;
			if(element(elemento).isEnabled()==true||contador==intentos) {
				System.out.println("Se encuentra elemento o contador finalizo");
				break;
			}else
				System.out.println("contador: " + contador + elemento);
		}
	}

	public void esperarElementoVisible(int intentos, WebElement elemento) throws Exception {
		try {
			int contador=0;
			System.out.println("Espera Elemento : "  + elemento.toString());
			Serenity.takeScreenshot();
			while(element(elemento).isCurrentlyVisible()==false) {
				contador++;
				if(element(elemento).isCurrentlyVisible()==true||contador==intentos) {
					System.out.println("Se encuentra elemento o contador finalizo");
					break;
				}else {
					Thread.sleep(1000);
					System.out.println("contador: " + contador + elemento);
				}
			}
		}catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new Exception("Se ha producido un error");
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new Exception("Se ha producido un error");
		}
	}

	public void esperarElementToClic(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void esperarVisibilityElement(WebDriver driver, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void esperarActivoClick(int intentos, WebElement elemento) {
		try{
			int contador=0;
			System.out.println("Espera Elemento : "  + elemento.toString());
			Serenity.takeScreenshot();
			while(element(elemento).isCurrentlyVisible()==false) {
				contador++;
				if(element(elemento).isCurrentlyVisible()==true&&element(elemento).isClickable()==true) {
					System.out.println("Se encuentra elemento o contador finalizo");
					break;
				}else {
					System.out.println("contador: " + contador);
					esperarSegundos(1);
				}
				if(contador==intentos)
					break;
			}
		}catch (NoSuchElementException e) {
			System.out.println("In catch block to handle no such element");
			e.printStackTrace();
		}
	}	
	
	public void esperarElementoClick(int intentos, WebElement elemento) {
		try{
			int contador=0;
			while(element(elemento).isEnabled()==false) {
				contador++;
				if(element(elemento).isClickable()==true||contador==intentos) {
					System.out.println("Se encuentra elemento");
					break;
				}else {
					System.out.println("contador: " + contador);
					esperarSegundos(1);
				}
			}
		}catch (NoSuchElementException e) {
			System.out.println("In catch block to handle no such element");
			e.printStackTrace();
		}
	}
	
//	public static void scrollToElement(AppiumDriver driver, String elementName, boolean scrollDown){
//		String listID = ((RemoteWebElement) driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ListView\")")).getId();
//		String direction;
//		if (scrollDown) {
//			direction = "down";
//		} else {
//			direction = "up";
//		}
//		HashMap<String, String> scrollObject = new HashMap<String, String>();
//		scrollObject.put("direction", direction);
//		scrollObject.put("element", listID);
//		scrollObject.put("text", elementName);
//		driver.executeScript("mobile: scrollTo", scrollObject);
//	}


	public void scroll() {
		appiumDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
	}

	public void scrollDown(WebDriver driver) {
		

		try {
		    driver.findElement(AppiumBy.androidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
		} catch (InvalidSelectorException e) {
			
			System.out.println(e.getMessage());
		    // ignore
		}
	}
	
	public void scrollUp(WebDriver driver) {
		

		try {
		    driver.findElement(AppiumBy.androidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
		} catch (InvalidSelectorException e) {
			
			System.out.println(e.getMessage());
		    // ignore
		}
	}
	//No funciona
	public void scrollToElemento(String text) {
		String auxiliar = "\"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + text +"\").instance(0))\"";
		System.out.println("********"  + auxiliar);
		appiumDriver().findElement(AppiumBy.androidUIAutomator(auxiliar));
//		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Empezar reembolso\").instance(0))"));
//		appiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Empezar reembolso\").instance(0))"));

	}
	
	public void esperarSegundos(int tipoEspera) {
		
		try {
			Thread.sleep(tipoEspera*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String obtenerFechayHora() {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmssSSS"); 
		 
		LocalDateTime today = LocalDateTime.now();     //Today

        String fecha =today.format(dtf);           
//        System.out.println(" horaaaa"  + fecha);
        return fecha;          
    }
	
	
	public int existeWebElementPorTexto(List<WebElement> elementos) {
		int conincidencia=0;
		for(int i=0; i<elementos.size(); i++) {
			try {
				if(elementos.get(i).isDisplayed()==true) {
					conincidencia++;
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		return conincidencia;
	}
	
	
	public boolean existeEntidadBancaria(WebElement elemento) {
		System.out.println("Entidad Bancaria "   + elemento.getText());
		if(elemento.getText().compareTo("BBVA")==0||elemento.getText().compareTo("Interbank")==0||elemento.getText().compareTo("Scotiabank")==0||elemento.getText().compareTo("BCP")==0) {
			return true;	
		}else {
			return false;
		}
		
		
	}
	
	public boolean existeEntidadBancaria2(WebElement elemento) {
		System.out.println("Entidad Bancaria "   + elemento.getText());
		if(elemento.isDisplayed()==true) {
			return false;	
		}else {
			return true;
		}
		
		
	}
	
	
	public void localizarElementoScroll(AppiumDriver driver, WebElement elemento) {
		while(element(elemento).isCurrentlyEnabled()==false) {
			Dimension dimension = appiumDriver().manage().window().getSize();
			//arrastrar hacia arriba, como deslizando la app para ver más contenido
			Point start= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.8));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.2)); 
			doSwipe(appiumDriver(), start, end, 1000); //with duration 1s
			System.out.println("Localizar ");
		}
		
		System.out.println("Encuentra ");
	}
	
	
	public static void doSwipeCoordenadas(AppiumDriver driver, int startX, int startY, int endX, int endY, int duracion) {
		Point startHorizontal= new Point(startX, startY);
		Point endHorizontal= new Point(endX, endY);
		doSwipe(driver, startHorizontal, endHorizontal, duracion);
    }
	
	
	

	public void scrollUno(WebDriver driver, String elementText) {
		
		try {
			driver.findElement(AppiumBy.androidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
	                        ".scrollIntoView(new UiSelector()" +
	                        ".textMatches(\"" + elementText + "\").instance(0))"));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void scrolldos(WebDriver driver) {
		try {
		    driver.findElement(AppiumBy.androidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
		} catch (InvalidSelectorException e) {
			
			System.out.println(e.getMessage());
		    // ignore
		}
	}
	

	
	

	
	public boolean buscarTextoLista(List<WebElement> elementos, String texto) {
		boolean exacto = false;		
		for(int i=0; i<elementos.size(); i++) {
//					System.out.println("Elemento " + elementos.get(i).getText() );
					if(elementos.get(i).getText().compareTo(texto)==0) {
						elementos.get(i).click();
						exacto = true;
					}
					}
				return exacto;
		
	}
	
	
	 public void verticalSwipeByPercentages(WebDriver driver, double startPercentage, double endPercentage, double anchorPercentage) {
	        Dimension size = driver.manage().window().getSize();
	        int anchor = (int) (size.width * anchorPercentage);
	        int startPoint = (int) (size.height * startPercentage);
	        int endPoint = (int) (size.height * endPercentage);
	        new TouchAction((PerformsTouchActions) driver)
	            .press(point(anchor, startPoint))
	            .waitAction(waitOptions(ofMillis(1000)))
	            .moveTo(point(anchor, endPoint))
	            .release().perform();
	    }
	 
	 
	 public static void scrollUp(WebDriver driver, String xpath) {
	        WebElement element = driver.findElement(ById.id(xpath));
	        if (element == null){
	            return;
	        }
	        int numberOfTimes = 10;
	        Dimension dimension = driver.manage().window().getSize();
	        int windowsHeight = dimension.getHeight();
//	        int scrollStart = (int) (windowsHeight * 0.5);
//	        int scrollEnd = (int) (windowsHeight * 0.3);
//	        
	   	 int scrollStart = (int) (windowsHeight * 0.3);
	   	 int scrollEnd = (int) (windowsHeight * 0.7);
	        int elementLocationOffset = windowsHeight-500;
	        for (int i = 0; i < numberOfTimes; i++) {
	            int elementLocationY = (element).getLocation().y;
	            if (elementLocationY < elementLocationOffset){
//	                i = numberOfTimes;
	                System.out.println("Element available.");
	                scroll(driver, scrollStart, scrollEnd);
	            }else {
	                scroll(driver, scrollStart, scrollEnd);
	                System.out.println("Element not available. Scrolling...");
	            }
	        }
	    }
	 
	  static void scroll(WebDriver driver, int scrollStart, int scrollEnd) {
	        new TouchAction((PerformsTouchActions) driver)
	                .press(point(0, scrollStart))
	                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
	                .moveTo(point(0, scrollEnd))
	                .release().perform();
	    }
	  
	  

		
		
		
		
		public void scrollTres(WebDriver driver) {
			PointOption pointOptionStart, pointOptionEnd;
			
			 Dimension dims = driver.manage().window().getSize();
		    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
		    pointOptionEnd = PointOption.point(dims.width / 2, (int)(dims.height*0.4));  
		    
		    System.out.println("Coordenadas "  + pointOptionStart  + " : "  + pointOptionEnd);
			TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
			touchAction.press(pointOptionStart)
			           .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
			           .moveTo(pointOptionEnd)
			           .release()
			           .perform();
		}
		
		public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {

			Sequence swipe = new Sequence(FINGER, 1)

			.addAction(FINGER.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))

			.addAction(FINGER.createPointerDown(LEFT.asArg()))

			.addAction(FINGER.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()))

			.addAction(FINGER.createPointerUp(LEFT.asArg()));

			((RemoteWebDriver) driver).perform(Arrays.asList(swipe));

			}

		public void mobileSwipeScreenAndroidFinal(){
			Dimension dimension = appiumDriver().manage().window().getSize();
			Point start= new Point((int)(dimension.width*0.2), (int)(dimension.height*0.9));
			Point end= new Point((int)(dimension.width*0.5), (int)(dimension.height*0.1));
			doSwipe(appiumDriver(), start, end, 1000);
		}

		public void mobileSwipeScreenAndroid() {

			PointOption pointOptionStart, pointOptionEnd;

			 

			    // init screen variables

			    Dimension dims = appiumDriver().manage().window().getSize();

			 

			    // init start point = center of screen

			    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

			    pointOptionEnd = PointOption.point(dims.width / 2, (int)(dims.height*0.4));

			   

			try {

			        new TouchAction((PerformsTouchActions) appiumDriver())

			                .press(pointOptionStart)

			                // a bit more reliable when we add small wait

			                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))

			                .moveTo(pointOptionEnd)

			                .release().perform();

			    } catch (Exception e) {

			        System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());

			        return;

			    }

			 

			}
		
		
		public String numeroMes(String mes) {
			String mesNumero="";
			
			switch (mes) {
				case "January":
				case "enero":
					mesNumero="01";
					break;

				case "February":
				case "febrero":
					mesNumero="02";
					break;

				case "March":
				case "marzo":
					mesNumero="03";
					break;

				case "April":
				case "abril":
					mesNumero="04";
					break;

				case "May":
				case "mayo":
					mesNumero="05";
					break;

				case "June":
				case "junio":
					mesNumero="06";
					break;

				case "July":
				case "julio":
					mesNumero="06";
					break;

				case "August":
				case "agosto":
					mesNumero="08";
					break;

				case "September ":
				case "setiembre":
					mesNumero="09";
					break;

				case "October":
				case "octubre":
					mesNumero="10";
					break;

				case "November":
				case "noviembre":
					mesNumero="11";
					break;

				case "December":
				case "diciembre":
					mesNumero="12";
					break;

				default:
					break;
				}
			
			return mesNumero;
			
		}
		
		public static Response ejecutarServicioPost(String uri, String path, String body,String header, String complemento, String parameters) {
//	        String jsonBody = getBody(body);
	        if(complemento.isEmpty()==false) {
	        	complemento="/" + complemento;
	        }
	        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(uri, path, 0);
	        requestSpecification.header("Content-Type", "application/json").header("deviceos",header);
//	        RequestSpecification restAssuredRequest = SerenityRest.given().contentType("application/json").accept("application/json").header("Content-Type", "application/json");
	        
	       
	        
//	       Response response = new RestAssuredConfiguration().getResponseTotalPost(requestSpecification.body(jsonBody), complemento);
	       Response response = new RestAssuredConfiguration().getResponseTotalPost(requestSpecification, complemento);
	        return response;
	    }
		
		public static String getBody(String body) {
	        JSONObject jsonParams = new JSONObject(body);
	        return jsonParams.toString();
	    }

		public static void pressEnter(AndroidDriver driver){
			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		}

		public void esperarMinutos(int minutos) {

			try {
				int contador=0;
				while(contador<minutos){
					Thread.sleep(60*1000);
					System.out.println("Espera en minutos: "+(contador+1));
					contador++;
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public void tapByCoordinates (AndroidDriver driver, double x,  double y) {
		Dimension dimension = appiumDriver().manage().window().getSize();
		//arrastrar hacia arriba, como deslizando la app para ver más contenido
		int horizontal= (int)(dimension.height*x);
		int vertical= (int)(dimension.width*y);

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(vertical, horizontal)).perform();
	}
	public void esperarElementoCondicion(int intentos, WebElement elemento, boolean condicion, String mensaje) {
		int contador=0;
		try {
			while( element(elemento).isCurrentlyVisible()==false ) {
				Thread.sleep(1000);
				System.out.println("contador visible: " + contador + elemento);
				if (contador == intentos) {
					System.out.println("no se encontro elemento: " + elemento);
					Serenity.takeScreenshot();
					break;
				}
				contador++;
				if(condicion){
					Serenity.takeScreenshot();
					System.out.println(mensaje);
					break;
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("In catch block to handle no such element");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("In catch block to handle Generic exception");
			e.printStackTrace();
		}
	}



}

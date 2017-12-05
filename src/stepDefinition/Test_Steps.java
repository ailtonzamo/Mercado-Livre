package stepDefinition;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	public static WebDriver driver;
	private WebDriverWait wait;
@Given("^Acessar a pagina do Mercado Livre\\.$")
public void acessar_a_pagina_do_Mercado_Livre() throws Throwable {
driver = new FirefoxDriver();
driver.manage().deleteAllCookies();
wait = new WebDriverWait(driver, 10);

	driver.manage().window().maximize();
    driver.navigate().to("https://www.mercadolivre.com.br/");

   // throw new PendingException();
}

@When("^No campo pesquisar,digitar o nome do produto\\.$")
public void no_campo_pesquisar_digitar_o_nome_do_produto() throws Throwable {
	 Thread.sleep(3000);
		driver.findElement(By.name("as_word")).sendKeys("carros usados");
		driver.findElement(By.name("as_word")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
  //  throw new PendingException();
}

@Then("^Exibir o titulo e o valor dos (\\d+) primeiros produtos\\.$")
public void exibir_o_titulo_e_o_valor_dos_primeiros_produtos(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	List<WebElement> links1 = driver.findElements(By.className("main-title"));
	List<WebElement> links = driver.findElements(By.className("item__price"));
		
			for(int i= 0; i<=4; i++) { 
				  		  
				  String Titulo = links1.get(i).getText();
				  String Preco = links.get(i).getText();
				  System.out.println(Titulo+"\n"+Preco);
   // throw new PendingException();
			}
			driver.quit();	
	}



@Then("^Tirar um print do penultimo anuncio da segunda pagina\\.$")
public void tirar_um_print_do_penultimo_anuncio_da_segunda_pagina() throws Throwable {
	  JavascriptExecutor js2 = (JavascriptExecutor) driver;
	  js2.executeScript ("window.scrollBy (0,7000)");
	
	List<WebElement> links = driver.findElements(By.className("prefetch"));
	
	links.get(0).click();
	Thread.sleep(2000);
	List<WebElement> links2 = driver.findElements(By.tagName("img"));
	int teste2=links2.size();
	teste2=teste2-2;
	//for(WebElement link : links2){
	

		//System.out.println("jhhhggg"+links2.get(teste2));
	
		links2.get(teste2).click();

		Thread.sleep(1000);
		List<WebElement> linksp = driver.findElements(By.className("modal__close"));
		
		linksp.get(0).click();

		
	IMG(teste2,"Dados");


}

public static  void IMG(int numPG,String Pasta) throws AWTException{
	try{

	Date now = new Date();
	DateFormat diaf = new SimpleDateFormat("dd");
	DateFormat mesf = new SimpleDateFormat("MM");
	DateFormat anof = new SimpleDateFormat("yyyy");
	String diaF = diaf.format(now);
	String mesF = mesf.format(now);
	String anoF = anof.format(now);
	String dataPasta = diaF + "_" + mesF + "_" + anoF;
//	TakesScreenshot oScn = (TakesScreenshot) driver;
//	 String endereco="c:\\tmp\\screenshot\\"+ dataPasta +"\\"+Pasta+"\\"+numPG;		 
	File sub = new File("C:\\Automacao\\AutoitDeploy\\BD\\Evidencias\\"+ dataPasta +"\\"+Pasta+"\\");
	sub.mkdirs();
//	FileUtils.copyFile(dir, new File("C:\\Automacao\\AutoitDeploy\\BD\\Evidencias\\"+ dataPasta +"\\"+Pasta+"\\"));	
	 Robot robot = new Robot();
     BufferedImage bi =robot.createScreenCapture(new Rectangle(0, 0, 1600, 900));
    ImageIO.write(bi, "jpg", new File("C:\\Automacao\\AutoitDeploy\\BD\\Evidencias\\"+ dataPasta +"\\"+Pasta+"\\"+numPG+".jpg"));// Salva a imagem
     
	

	} catch(Exception e){
		System.out.println(e);
	}
}




}

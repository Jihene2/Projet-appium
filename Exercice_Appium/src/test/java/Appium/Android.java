package Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test; 
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Android {

	@Test
	public void OpenApp() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities  caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3 XL API 30");
		WebDriverManager.chromedriver().setup();
		caps.setCapability("chromedriverExecutable",WebDriverManager.chromedriver().getDownloadedDriverPath());
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		//Accéder à la page amazon.in
		driver.get("https://www.amazon.in");
		
		//Saisir la requête de recherche 
		driver.findElement(By.xpath("//*[@id=\"nav-search-keywords\"]")).sendKeys("mobiles");
		
		//Cliquer sur valider la recherche (loupe)
		driver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div[2]/div/input")).click();
		 Thread.sleep(4000);
		 
		 //Sélectionner l'article 
		driver.findElement(By.className("s-image")).click();
		
		//Ajouter au panier 
		driver.findElement(By.id("add-to-cart-button")).click();
		
		
	}
}

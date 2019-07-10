package interPromobi;


	import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.Set;
    import java.util.concurrent.TimeUnit;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.ui.Select;
   //import org.openqa.selenium.interactions.Action;
	import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;

	public class Flipkart {
		WebDriver driver;
		String currentWindoHandle;  
		@BeforeTest
		 public void launchBrowser()
		 {
			 System.out.println("beforetest");
 
		        System.setProperty("webdriver.chrome.driver","d:\\Tools\\WSPace\\PromobiJars\\chromedriver.exe ");
			    driver=new ChromeDriver();	
				driver.manage().deleteAllCookies(); 
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(180,TimeUnit.SECONDS);
				System.out.println("test");
	     		driver.get("https://www.flipkart.com");
				 
		 }

			 @Test(priority=1)
			 public void searchForProduct() throws InterruptedException
			 {
				 Thread.sleep(3000);
				 Actions act1=new Actions(driver);
                 act1.sendKeys(Keys.ESCAPE).build().perform();				
                 Thread.sleep(3000);
                 currentWindoHandle=driver.getWindowHandle();            
                 WebElement search =driver.findElement(By.name("q"));
                 search.click();
                 search.sendKeys("Apple iPhone X");
                 WebElement searchBtn =driver.findElement(By.className("vh79eN"));
                 searchBtn.click();
                 System.out.println("test1 executed");

			 }

		   
		  
		 @Test(priority=2)
		 public void selProdAndOpenDescription() throws InterruptedException
		 {
			 //select product and to open in new tab to view description
			 //Note:-
			  // below line is replaced by other product(Apple iPhone X (Silver, 256 GB)) as "Apple iPhone X (Space Gray, 256 GB)" becomes out of stock
			  
			 /*WebElement Ele2 =driver.findElement(By.xpath("//*[text()='Apple iPhone X (Space Gray, 256 GB)']"));*/
			  WebElement Ele2 =driver.findElement(By.xpath("//*[text()='Apple iPhone X (Silver, 256 GB)']"));
			  Ele2.click();                                 
			  Thread.sleep(4000);						 
			  ArrayList<String> windowHandles =new ArrayList<String>(driver.getWindowHandles());
              System.out.println(windowHandles.size());
              for(String window:windowHandles) 
                 {
	            if (window==currentWindoHandle) 
	                {
		              driver.switchTo().window(windowHandles.get(1));
		              
			        }
	             }
             String Ts =driver.getTitle();
             System.out.println(Ts); 
             //Add to cart 
             Thread.sleep(2000);						 
             driver.switchTo().window(windowHandles.get(1)).findElement(By.xpath("//*[text()='ADD TO CART']")).click();
             //modify its quantity 
             WebElement test=driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div[2]/div[1]/div/button[2]"));
             Thread.sleep(1000); 
             test.click();
              driver.switchTo().window(windowHandles.get(1)).findElement(By.xpath("//*[text()='Place Order']")).click();
          		 }
		 
		 @Test(priority=3)
  		 public void loginToFlipkart() throws InterruptedException
  		 {
           //order item using any user, enter mobile number and password for any user
           WebElement entrMobNo =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input"));
           entrMobNo.click();
           entrMobNo.sendKeys("7304069014");
               //Note:-1)Sometimes ask for mobile No and password comes on page at a time 
                    // 2)sometimes ask for mobile number then click on continue button 
                 //here only second case is handled
        
           Thread.sleep(1000);                            
           
           WebElement coNtin =driver.findElement(By.xpath("//*[text()='CONTINUE']"));
           coNtin.click();
           Thread.sleep(2000);
           WebElement entPass=driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[2]/input"));
           entPass.sendKeys("smkokate22");
           Thread.sleep(2000);
           WebElement logIn =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[3]/button"));
           logIn.click();
  		 }
		 @Test(priority=4)
		 public void enterDeleveryAddress() throws InterruptedException
		 { 
			 Thread.sleep(2000);
			 //order the item to a new address (Promobi's),click on add new address
			 WebElement addNewAdd =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]"));
			 addNewAdd.click();
			 //enter name 
			 WebElement addName =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/form/div/div[2]/div[1]/input"));
			 addName.click();
			 addName.sendKeys("ProMobi Technologies");
			 //enter add mobile no
			 WebElement addMob =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/form/div/div[2]/div[2]/input"));
			 addMob.click();
			 addMob.sendKeys("8983235684");
			 //pinCode	
			 WebElement pinCode =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/form/div/div[3]/div[1]/input"));
			 pinCode.click();
			 pinCode.sendKeys("411014");
			 //	 locality
			 WebElement locaLity =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/form/div/div[3]/div[2]/input"));
			 locaLity.click();
			 locaLity.sendKeys("Viman Nagar");
			 //Areaand street
			 WebElement areaNstreet =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/form/div/div[4]/div/div[1]/textarea"));
			 areaNstreet.click();
			 areaNstreet.sendKeys(" Off, Pune - Ahmednagar Hwy");
			 //City town dist	
			 WebElement cityTownDist =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/form/div/div[5]/div[1]/div[1]/input"));
			 cityTownDist.click();
			 cityTownDist.sendKeys("Pune,Maharashtra");
            //Select State
			 WebElement stCombo =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/form/div/div[5]/div[2]/div/div[2]/select"));
			 Select selSt =new Select(stCombo);
			 selSt.selectByVisibleText("Maharashtra");
			
			 //Enter landmark
			 WebElement landMark =driver.findElement(By.xpath("//input[@name='landmark']"));
			 landMark.click();
			 landMark.sendKeys("Viman nagar");
			
			 //Alternet number
			 WebElement altNo =driver.findElement(By.xpath("//input[@name='alternatePhone']"));
			 altNo.click();
			 altNo.sendKeys("8788419546");
			//Address type
		 WebElement checkBtn =driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/form/div/div[7]/div/div/label[2]/div[1]"));
		 checkBtn.click();
		 
         //save and delever at address
		 //Below code commented because in the assignment it is mentioned that order process till address page   
		
		 /* WebElement saveNDelever =driver.findElement(By.xpath("//*[text()='Save and Deliver Here']"));
		 saveNDelever.click();
		 */
		 }
		 
		   @AfterTest
		      public void logOut() throws InterruptedException
		   {
			
				 WebElement chanGe =driver.findElement(By.xpath("//*[text()='Change']"));
				 chanGe.click();
				 Thread.sleep(2000);
				 WebElement logOut =driver.findElement(By.xpath("//*[text()='Logout & Sign in to another account']"));
				 logOut.click();
				 System.out.println("Thank You");
			   //driver.close();
		      
			/*	 Note:
					 Thread.sleep() is used to synchronize with (mobile) internet speed
				*/		 
			}
}

package com.amazon.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.amazon.Pages.MainPage;
import com.amazon.Util.Constants;


public class MainTest extends BaseTest {
	
	public static MainPage mpObj(){
		
		MainPage mp = new MainPage(driver);	
		PageFactory.initElements(driver,mp);
		return mp;
	}
	
		@Test(priority=1)
		   public void URLOpen(){
				
			init(Constants.BROWSER_TYPE);
		
			MainPage mp = new MainPage(driver);
			mp.openURL(driver);
		
			  Assert.assertTrue(driver.getTitle().contains("Amazon"),"Main Page is NOT displayed"); 
			  System.out.println("Main Page is displayed");
		}
		
		@Test (priority=2)
		   public void SelectBooks() throws InterruptedException {
			
			   mpObj().selectItem("Books");
			   
			   Assert.assertTrue(driver.getTitle().contains("Amazon"),"Books category not chosen");
			   System.out.println("Books category is chosen");
		}
		
		@Test(priority=3)
			public void SearchBook() throws InterruptedException {
			
			   mpObj().searchItem("data catalog");
			
			   Assert.assertTrue(driver.getTitle().contains("Amazon"),"Search is not performed");
			   System.out.println("Search is performed");
		}
	
		@Test(priority=4)
			public void ChooseBook() throws InterruptedException {
			
			   mpObj().chooseItem();
		}
		
		@Test(priority=5)
			public void ReceiveTitle() throws InterruptedException {
			
			   mpObj().getBookTitle();
		}

		@Test(priority=6)
			public void ObtainAuthors() throws InterruptedException {
			
			   mpObj().getBookAuthors();
		}
		
		@Test(priority=7)
			public void DrawKindlePrice() throws InterruptedException {
			
				mpObj().getbookKindlePrice();
		}
		
		@Test(priority=8)
		public void DrawPaperPrice() throws InterruptedException {
		
			mpObj().getbookPaperPrice();
		}
		
		@AfterClass
		public void driverClose(){
			driver.close();
		}
		
}

package com.amazon.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.amazon.Util.Constants;


public class MainPage extends BasePage {
	
	public MainPage(WebDriver driver){
		super(driver);
	}
	
	public void openURL(WebDriver driver){
		driver.get(Constants.PAGE_URL);
	}
	
	@FindBy(id="searchDropdownBox")
	private WebElement MAINPAGE_ALL_DROPDOWN;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement MAINPAGE_SEARCHBOX;
	
	@FindBy(className="s-image")
	private WebElement PRODUCT_IMAGE;
	
	@FindBy(id="productTitle")
	private WebElement PRODUCT_TITLE;
	
	@FindBy(id="bylineInfo")
	private WebElement PRODUCT_AUTHOR;
	
	@FindBy(id="mediaTab_heading_0")
	private WebElement KINDLE_PRICE;
	
	@FindBy(id="mediaTab_heading_1")
	private WebElement PAPERBACK_PRICE;
	
	public void selectItem (String item) {
		Select sel = new Select(MAINPAGE_ALL_DROPDOWN);
		sel.selectByVisibleText(item);
	}
	
	public void searchItem(String data) throws InterruptedException {
		MAINPAGE_SEARCHBOX.sendKeys(data);
		MAINPAGE_SEARCHBOX.sendKeys(Keys.ENTER);
	}
	
	public void chooseItem() throws InterruptedException {
		PRODUCT_IMAGE.click();
	}
	
	public void getBookTitle() throws InterruptedException {
		String bookTitle = PRODUCT_TITLE.getText();
		System.out.println("Book Title :"+bookTitle);
	}
	
	public void getBookAuthors() throws InterruptedException {
		String bookAuthors= PRODUCT_AUTHOR.getText();
		System.out.println("Book by :"+bookAuthors);
	}
	
	public void getbookKindlePrice() throws InterruptedException{
		String kindlePrice= KINDLE_PRICE.getText();
		System.out.println("Price of kindle version :"+kindlePrice);
	}
	
	public void getbookPaperPrice() throws InterruptedException {
		String PaperbackPrice= PAPERBACK_PRICE.getText();
		System.out.println("Price of Paperback version :"+PaperbackPrice);
	}
}



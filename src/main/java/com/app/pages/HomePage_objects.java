package com.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage_objects extends Basepage {
	public HomePage_objects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class = 'logo img-responsive']")
	private WebElement Homepage;

	@FindBy(xpath = "//ul/li[1]/a[@title='Women']")
	public WebElement tabWomen;

	@FindBy(xpath = "//ul[contains(@class,'clearfix menu-content')]/li[2]/a[@title='Dresses']")
	public WebElement tabDresses;

	@FindBy(xpath = "//ul[contains(@class,'clearfix menu-content')]/li[3]/a[@title='T-shirts']")
	public WebElement tabtshirts;

	@FindBy(id = "newsletter-input")
	public WebElement txtEmail;

	@FindBy(xpath = "//*[@name='submitNewsletter']")
	public WebElement btnEmail;

	@FindBy(xpath = "//*[@class='alert alert-success']")
	public WebElement MsgEmail;

	@FindBys(@FindBy(xpath = "//*[@id = 'homefeatured']/li"))
	public List<WebElement> ProdLists;

	public void getHomepage()
	{
		Homepage.click();
	}
	public void getWomenTab() {
		tabWomen.click();
	}

	public void getDressesTab() {
		tabDresses.click();

	}

	public void getTshirtsTab() {
		tabtshirts.click();

	}

	public WebElement getEmail() {
		return txtEmail;
	}

	public void getbtnEmail() {
		btnEmail.click();
	}

	public WebElement getMsgEmail() {
		return MsgEmail;
	}

	public List<WebElement> getproduct() {
		return ProdLists;
	}

	public boolean verifyAddtoCart(WebElement parent) {
		return elementFound(parent.findElement(By.xpath(".//*[text()='Add to cart']")));
	}

	public String getProductName(WebElement parent) {
		return parent.findElement(By.xpath(".//*[@class='product-name']")).getText();
	}
}

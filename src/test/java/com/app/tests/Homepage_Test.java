package com.app.tests;

import static org.testng.Assert.assertTrue;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.app.pages.Basepage;
import com.app.pages.HomePage_objects;

import junit.framework.Assert;

public class Homepage_Test 
{
	HomePage_objects hp;
	public Homepage_Test() 
	{
		hp = new HomePage_objects();
	}
	@BeforeMethod
	public void clickHomepage() 
	{
		hp.getHomepage();
		System.out.println("homepage");
	}
	
	/*@AfterClass
	public void closedriver()
	{
		System.out.println("Executing after class");
		hp.quitDriver();
	}*/
	
	@Test(groups= {"HomePage"})
	public void VerifyTabs() 
	{
		Assert.assertTrue("Womens Tab not found", hp.elementFound(hp.tabWomen));
		Assert.assertTrue("dresses tab not found", hp.elementFound(hp.tabDresses));
		Assert.assertTrue("dresses tab not found", hp.elementFound(hp.tabtshirts));
	}

	@Test(groups= {"HomePage","Sanity"})
	public void Verifypage() {
		hp.getWomenTab();
		Assert.assertTrue("Not navigated to Womens page", hp.verifyTitle("Women - My Store"));
		hp.Winback();
		hp.getDressesTab();
		Assert.assertTrue("Not navigated to Dresses page", hp.verifyTitle("Dresses - My Store"));
		hp.Winback();
		hp.getTshirtsTab();
		Assert.assertTrue("Not navigated to T-Shirts page", hp.verifyTitle("T-shirts - My Store"));
	}

	@Test(groups= {"HomePage","Sanity"})
	public void EnterMail() {
		hp.txtEmail.sendKeys("xw21@gmail.com");
		hp.getbtnEmail();
		System.out.println("The message is ==>" + hp.getMsgEmail().getText());
		Assert.assertTrue("Failed",
				hp.verifyText(hp.getMsgEmail(), "Newsletter : You have successfully subscribed to this newsletter."));
	}

	@Test(groups= {"HomePage","Sanity"})
	public void VerifyAddToButton() {
		List<WebElement> products = hp.getproduct();
		for (WebElement prod : products) {
			hp.myActions(prod);
			Assert.assertTrue("Failed", hp.verifyAddtoCart(prod));
			// Assert.assertTrue(hp.verifyAddtoCart(prod),"Failed");
		}
	}
}

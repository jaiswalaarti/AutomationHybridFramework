package com.visionit.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.visionit.automation.base.BasePage;
import com.visionit.automation.utils.AppConstants;
import com.visionit.automation.utils.ElementActions;
import com.visionit.automation.utils.WaitUtil;

public class LandingPage extends BasePage  {

	private static final Logger logger = LogManager.getLogger(LandingPage.class);

	ElementActions elementActions;
	
	
	// By Locators - Landing Page
	private By landingPageLogoImage = By.xpath("//img[@class='logo img-responsive']");
	private By landingPageProdCategoryList = By.xpath("//div[@id='block_top_menu']/ul/li/a");
	private By SigninButtonElement = By.xpath("//div/a[contains(text(),'Sign in')]");
    private By  searchBoxElement = By.xpath("//input[@type='text'and @name='search_query']");
    private By listOfDresses = By.xpath("//div[@class='ac_results']/ul/li");
	private By containsDressKeyword = By.xpath("//div[@class='ac_results']/ul/li[contains(text(),'Dress')]");
	private By DressButton  = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']");
    //private By allDressPrice = By.xpath("//div[@class='right-block']//span[@class='price product-price' and @itemprop='price']");
    private By allDressPrice =By.xpath("//div[@class='product-container']//div[@class='right-block']//span[@class='price product-price' and @itemprop='price']");
    private By registeredEmailidElement = By.id("email");
	private By alreadyCreatedPasswordElement = By.id("passwd");
	private By clickOnSignInButton1 = By.xpath("//*[@id='SubmitLogin']");
	
	//locator for T-shirt element 
	private By clickOnTshirtElement = By.xpath("//div[@id='block_top_menu']/ul/li[3]/a");
	//locator for faded short sleeves t-shirt
	private By shortSleevesImage = By.xpath("//div[@class='right-block']/h5/a[@class='product-name']");
	private By SendToFriend = By.id("send_friend_button");
	
	//locator for more option in faded short sleeves t-shirt
	private By moreOption = By.xpath("//a[@title='View']//span");
	//locator for friend name and email-id
	
	private By friendNameelement = By.xpath("//input[@id='friend_name']");
	private By friendEmailId = By.xpath("//input[@id='friend_email']");
	
	//locator for send email
	private By send= By.id("sendEmail");
	
	//locator for this->'Your e-mail has been sent successfully' element and element for ok button
	private By sentEmailMessageElement = By.xpath("//p[normalize-space()='Your e-mail has been sent successfully']");
	private By okButtonElement = By.xpath("//input[@type='button' and @value='OK']");
	
	//locator for blue color box element
	private By blueColorBoxElement = By.xpath("//a[@id='color_2']");
	
	//locator for blue color image
    private By blueColorImgElement =By.xpath("//img[@id='bigpic']");
    
   //locator to mousehover 
   private By mouseHover1 = By.xpath("//div[@class='right-block']");
   private By mouseHover2 = By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line']//a[@title='Blouse'][normalize-space()='Blouse']");
   private By mouseHover3 = By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']//a[@title='Printed Chiffon Dress'][normalize-space()='Printed Chiffon Dress']");
   //locators for add to cart products
   private By addToCartProduct1 = By.xpath("//ul[@id='homefeatured']//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//span[contains(text(),'Add to cart')]");
   private By addToCartProduct2 = By.xpath("//ul[@id='homefeatured']//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line']//span[contains(text(),'Add to cart')]");
   private By addToCartProduct3 = By.xpath("//ul[@id='homefeatured']//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']//span[contains(text(),'Add to cart')]");
   private By continueShoppingElement = By.xpath("//span[@class='continue btn btn-default button exclusive-medium']//span");
   
   private By cartelement = By.xpath("//div[@class='shopping_cart']");
	
	
	// Constructor of the page:
	public LandingPage(WebDriver driver) {
		elementActions = new ElementActions(driver);
	}
	
	
	// Page Actions:
	public String getLandingPageUrl()
	{
		elementActions.waitForUrlWithTextContains(AppConstants.LANDING_PAGE_REDIRECTED_URL);
		String currentUrl = elementActions.doGetcurrentURL();
		return currentUrl;
		
	}
	
	public String getLandingTitle()
	{
		String landingPageTitle = elementActions.waitForPageTitleToBe(AppConstants.LANDING_PAGE_TITLE);
		return landingPageTitle;
	}
	
	public List<WebElement> getLandingPageProdCategory()
	{
		List<WebElement> landingPageProdCategoryActual = elementActions.getElementsList(landingPageProdCategoryList);
		return landingPageProdCategoryActual;
	}
	
	public boolean getLandingPageLogo()
	{
		elementActions.waitForElementVisible(landingPageLogoImage);
		boolean landingPageLogoStatus = elementActions.doIsDisplayed(landingPageLogoImage);
		return landingPageLogoStatus;
	}
	
	public String getLogoHeight() {
		String logoHeight = elementActions.getAttributeValue(landingPageLogoImage,"height");
		return logoHeight;
	
		}
	public String getLogoWidth() {
		String logoWidth = elementActions.getAttributeValue(landingPageLogoImage,"width");
		return logoWidth;
		}
	public void clickonSignin() {
		elementActions.doClick(SigninButtonElement);
		
	}
	
	public String getLoginTitle()
	{
		String getLoginPageTitle = elementActions.waitForPageTitleToBe(AppConstants.LOGIN_PAGE_TITLE1);
		return getLoginPageTitle;
	}
	public boolean enabledSearchBox() {
		elementActions.waitForElementVisible(searchBoxElement);
		boolean searchBox = elementActions.doIsEnabled(searchBoxElement);
		return searchBox;
		}
	
	public void matchingProduct() {
		elementActions.doSendKeys(searchBoxElement, AppConstants.SEARCH_KEYWORD);
	    List<WebElement> list = elementActions.getElementsList(listOfDresses);
	    logger.info("total dress list size  is: "+list.size());
	    logger.info("the complete list is as below");
	    for(int i=0;i<list.size();i++) {
	    	logger.info(list.get(i).getText());
	    }
	    List<WebElement> listContainsDress = elementActions.getElementsList(containsDressKeyword);
	     logger.info("total dress list with dress keyword is :"+listContainsDress.size());
	    logger.info("the complete list  with dress keyword is as below");
	    for(int j=0;j<listContainsDress.size();j++) {
	    	logger.info(listContainsDress.get(j).getText());
	    	}
	    int listContainDressCount = listContainsDress.size();	
	    Assert.assertEquals(listContainDressCount,5,"list size is not 5");
	    }
	 public boolean DressButtonDisplayed(){
		 boolean dressDisplayed = elementActions.doIsDisplayed(DressButton);
		 return dressDisplayed;
		 }
		 
	 public void AllProductPriceAndItsTotal() {
		 elementActions.doClick(DressButton);
		 List<WebElement> priceOfAllDresses = elementActions.getElementsList(allDressPrice);
		 logger.info("prices of all dresses is as below");
		 for(int p=0;p<priceOfAllDresses.size();p++) {
			 logger.info(priceOfAllDresses.get(p).getText());
		 }
	 }
	 
	 public void LoginIntoAccount() {
		 elementActions.doSendKeys(registeredEmailidElement, AppConstants.REGISTERED_EMAIL_lId);
		 elementActions.doSendKeys(alreadyCreatedPasswordElement, AppConstants.REGISTERED_PSSWRD);
		 elementActions.doClick(clickOnSignInButton1);
		 elementActions.doClick(clickOnTshirtElement);
		 elementActions.waitForElementVisible(shortSleevesImage);
		 elementActions.doMoveToElement(shortSleevesImage);
		 elementActions.doClick(moreOption);
		 elementActions.doClick(SendToFriend);
		 elementActions.doSendKeys(friendNameelement, AppConstants.FRIEND_NAME);
		 logger.info("enterd name of friend is: "+AppConstants.FRIEND_NAME);
		 elementActions.doSendKeys(friendEmailId, AppConstants.FRIEND_EMAIlId);
		 logger.info("enterd emailid of friend is: "+AppConstants.FRIEND_EMAIlId);
		 elementActions.doClick(send);
		 elementActions.doGetText(sentEmailMessageElement);
		 elementActions.doClick(okButtonElement);
	 }
	 
	 public void changeImageColor() {
		 elementActions.doClick(clickOnTshirtElement);
		 elementActions.waitForElementVisible(shortSleevesImage);
		 elementActions.doClick(blueColorBoxElement);
		 //WaitUtil.shortWait();
		// elementActions.waitForElementVisible(blueColorImgElement);
		 logger.info("clicked on blue colour to change colour or t-shirt");
		 new BasePage().getScreenshot();
		 logger.info("ScreenShot of changed colour of image is captured");
		 
	 }
	 
	 public void updateCartValue() {
		 elementActions.doMoveToElement(mouseHover1);
		 elementActions.waitForElementClickable(addToCartProduct1);
		 WaitUtil.mediumWait();
		 elementActions.doClick(addToCartProduct1);
		 elementActions.waitForElementClickable(continueShoppingElement);
		 elementActions.doClick(continueShoppingElement);
		 logger.info("1st product added to cart");
		 elementActions.doMoveToElement(mouseHover2);
		 elementActions.doClick(addToCartProduct2);
		 elementActions.waitForElementClickable(continueShoppingElement);
		 elementActions.doClick(continueShoppingElement);
		 logger.info("2nd product added to cart");
		 elementActions.doMoveToElement(mouseHover3);
		 elementActions.doClick(addToCartProduct3);
		 elementActions.waitForElementClickable(continueShoppingElement);
		 elementActions.doClick(continueShoppingElement);
		 logger.info("3rd product added to cart");
		 elementActions.doGetText(cartelement);
		 logger.info("Total product added in cart are:"+cartelement);
		 
	 }
	 }
	


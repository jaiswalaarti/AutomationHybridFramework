package com.visionit.automation.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.visionit.automation.base.BaseTest;
import com.visionit.automation.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(LandingPageTest.class);
	
	@Test
	public void tc_01_verify_landing_page_url_redirection() {
		
		logger.info("Test case started: tc_01_verify_landing_page_url_redirection");
		
		String landingPageActulaRedirectedUrl = landingPage.getLandingPageUrl();
		logger.info("Landing page actual redirected URl is : " + landingPageActulaRedirectedUrl);
		Assert.assertEquals(landingPageActulaRedirectedUrl, AppConstants.LANDING_PAGE_REDIRECTED_URL);
		
		logger.info("Test case ended: tc_01_verify_landing_page_url_redirection");
	}
	
	@Test
	public void tc_02_verify_landing_page_title() {
		
		logger.info("Test case started: tc_02_verify_landing_page_title");
		
		String landingPageActualTitle = landingPage.getLandingTitle();
		logger.info("Landing page actual title is : " + landingPageActualTitle);
		Assert.assertEquals(landingPageActualTitle, AppConstants.LANDING_PAGE_TITLE);
		
		logger.info("Test case ended: tc_02_verify_landing_page_title");
	}
	
	@Test(enabled=true)
	public void tc_03_verify_product_category_landing_page() {
		
		logger.info("Test case started: tc_03_verify_product_category_landing_page");
		
		// adding actual product categories from landing page to the logs
		List<WebElement> landingPageProdCategoryActual = landingPage.getLandingPageProdCategory();
		logger.info("Landing page actual prod category list contains : ");
		for (int i = 0; i < landingPageProdCategoryActual.size(); i++) {
			logger.info((i+1) + ". " + landingPageProdCategoryActual.get(i).getText());
		}
		
		// adding expected product categories for the landing page to the logs
		ArrayList<String> landingPageProdCategoryExpected = AppConstants.landingPageProdCategoryExpected();
		logger.info("Landing page exepcted prod category list contains : ");
		for (int i = 0; i < landingPageProdCategoryExpected.size(); i++) {
			logger.info((i+1) + ". " + landingPageProdCategoryExpected.get(i));
		}
		
		// Validating the actual vs expected product categories
		for (int i = 0; i < landingPageProdCategoryExpected.size(); i++) {
			if (landingPageProdCategoryExpected.get(i).contentEquals(landingPageProdCategoryActual.get(i).getText())) {
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		}	
		
		logger.info("Test case ended: tc_03_verify_product_category_landing_page");
	}
	
	@Test
	public void tc_04_verify_landing_page_logo_visiblity() {
		
		logger.info("Test case started: tc_04_verify_landing_page_logo_visiblity");
		
		boolean landingPageLogoVisiblity = landingPage.getLandingPageLogo();
		logger.info("Visibility status of application logo is : " + landingPageLogoVisiblity);
		Assert.assertEquals(landingPageLogoVisiblity, true);
		
		logger.info("Test case ended: tc_04_verify_landing_page_logo_visiblity");
	}


   @Test
   public void tc_5_validateApplicationLogoHeightOnLandingPage() {
	   logger.info("Test case 5 started: tc_5_validateApplicationLogoHeightOnLandingPage");  
	   
	   String landingpageLogoHeight = landingPage.getLogoHeight();
	   logger.info("landing page logo height is "+landingpageLogoHeight);
	   Assert.assertEquals(landingpageLogoHeight, "99", "the logo height is not 99");
	   logger.info("Test case 5 started: tc_5_validateApplicationLogoHeightOnLandingPage");
	   }
   
   @Test
   public void tc_6_Validate_Application_Logo_Width_On_Landing_page() {
	   logger.info("Test case 6 started: tc_6_Validate_Application_Logo_Width_On_Landing_page");
	   String landingpageLogoWidth = landingPage.getLogoWidth();
	   logger.info("landing page logo width is "+landingpageLogoWidth);
	   Assert.assertEquals(landingpageLogoWidth, 350, "the logo width is not 350");
	   logger.info("Test case 6 ended: tc_6_Validate_Application_Logo_Width_On_Landing_page");
   }
   
   @Test
   public void tc_7_SignIn_page_TitleValidation_Test() {
	   logger.info("Test case 7 started: SignIn page Title Validation Test");
	   landingPage.clickonSignin();
	   logger.info("clicked on sign in button");
	   String ActualLoginPageTitle = landingPage.getLoginTitle();
	   logger.info("login page title is "+ActualLoginPageTitle);
	   Assert.assertEquals(ActualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE1, "page Title didn't match");
	   logger.info("Test case 7 ended: SignIn page Title Validation Test");
	   }
   
   @Test
   public void tc_9_Search_Product_In_SearchBox_And_Validate_Matching_Products() {
	   logger.info("Test case 9 started: Search produt in search box and validation products");
	   boolean searchBox = landingPage.enabledSearchBox();
	   logger.info("The earch box is enabled "+searchBox);
	   landingPage.matchingProduct();
	    }
    @Test 
    public void tc_10_Fetch_the_all_product_price_and_get_its_total() {
    	logger.info("The Test case 10 started: Fetch the all product price and get its total");
        landingPage.DressButtonDisplayed();
   	    landingPage.AllProductPriceAndItsTotal();
 //validation of total price of product is not done.
        logger.info("The Test case 10 started: Fetch the all product price and get its total");

    }
    @Test
    public void tc_11_Send_a_Friend_Feature() {
    	logger.info("The Test Case 11 started: Send a Friend Feature");
    	landingPage.clickonSignin();
  	    logger.info("clicked on sign in button");
  	    landingPage.LoginIntoAccount();
    	logger.info("The Test Case 11 started: Send a Friend Feature");
    	}
    @Test
    public void tc_12_Change_in_the_image_using_Color_Feature() {
    	logger.info("Test case 12 started: Change in the image using Color Feature");
    	landingPage.changeImageColor();
     	logger.info("Test case 12 ended: Change in the image using Color Feature");
    }
    @Test
    public void tc_17_Validate_cart_value_is_updating() {
    	logger.info("Test Case 17 started: tc_17_Validate_cart_value_is_updating");
    	landingPage.updateCartValue();
    	logger.info("Test Case 17 ended: tc_17_Validate_cart_value_is_updating");

    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   }
  
  
  
  
  
  
  
  
  
  
  
  
  
  



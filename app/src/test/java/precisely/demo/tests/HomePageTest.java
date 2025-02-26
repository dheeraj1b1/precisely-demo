package precisely.demo.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import precisely.demo.util.DriverSingleton;
import precisely.demo.pages.HomePage;
import precisely.demo.pages.ProductPage;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.get("https://www.precisely.com/"); // Update with actual URL
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);

    }

   
    @Test
    public void testNavigationFlow() throws InterruptedException {
        homePage.goToProductPage();
        homePage.goToSolutionPage();
        homePage.goToResourcePage();
        homePage.goToAboutUsPage();
        homePage.goToContactPage();
        homePage.goToProductPage();
        List<String> productTexts = productPage.getProductsText();
         Assert.assertTrue(productTexts.contains("Integrate"));
        Assert.assertTrue(productTexts.contains("Connect today's infrastructure with tomorrow's technology"));


    }


    @AfterClass
    public void tearDown() {
        DriverSingleton.quitDriver();
    }
}
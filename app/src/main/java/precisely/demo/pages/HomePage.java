package precisely.demo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
     private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "(//header[@class='banner']//a[text()='Products'])[2]")
    private WebElement productBtn;

    @FindBy(xpath = "(//div[contains(@id, 'mega-menu')]//a)[1]")
    private WebElement productDropBtn;

    // @FindBy(xpath = "(//header[@class='banner']//a[text()='Solutions'])[2]")
    // private WebElement solutionBtn;
    @FindBy(xpath = "(//li[contains(@class, 'menu-item-25479')])[2]")
    private WebElement solutionBtn;
    

    @FindBy(xpath = "(//li[contains (@class, 'menu-item-25479')]//a)[165]")
    private WebElement solutionDropBtn;

    @FindBy(xpath = "(//header[@class='banner']//a[text()='Resources'])[2]")
    private WebElement resoucreBtn;

    @FindBy(xpath = "(//li[contains (@class, 'menu-item-112399')]//a)[73]")
    private WebElement resoucreDropBtn;

    @FindBy(xpath = "(//header[@class='banner']//a[text()='Support'])[2]")
    private WebElement supportBtn;

    @FindBy(xpath = "(//header[@class='banner']//a[text()='About us'])[3]")
    private WebElement aboutBtn;

    @FindBy(xpath = "(//li[contains (@class, 'menu-item-489')]//a)[43]")
    private WebElement aboutDropBtn;

    @FindBy(xpath = "(//div[contains(@class, 'right-menu')]//a[text()='Get in touch'])[1]")
    private WebElement contactBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToProductPage() {
        waitForElementToBeClickable(productBtn);
        productBtn.click();
        waitForElementToBeClickable(productDropBtn);
        productDropBtn.click();
        logger.info("Landed on Product Page");
    }

    public void goToSupportPage() {
        waitForElementToBeClickable(supportBtn);
        supportBtn.click();
    }

    public void goToResourcePage() {
        waitForElementToBeClickable(resoucreBtn);
        resoucreBtn.click();
        waitForElementToBeClickable(resoucreDropBtn);
        resoucreDropBtn.click();
        logger.info("Landed on Resource Page");
    }

    public void goToSolutionPage() {
        waitForElementToBeClickable(solutionBtn);
        solutionBtn.click();
        waitForElementToBeClickable(solutionDropBtn);
        solutionDropBtn.click();
        logger.info("Landed on Solution Page");
    }

    public void goToAboutUsPage() {
        waitForElementToBeClickable(aboutBtn);
        aboutBtn.click();
        waitForElementToBeClickable(aboutDropBtn);
        aboutDropBtn.click();
        logger.info("Landed on About Us Page");
    }

    public void goToContactPage() {
        waitForElementToBeClickable(contactBtn);
        contactBtn.click();
        logger.info("Landed on Contact Page");
    }
    

    // Helper method to wait for element to be clickable
    private void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

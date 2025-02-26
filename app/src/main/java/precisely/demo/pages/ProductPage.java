package precisely.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    @FindBy(xpath = "//div[@class='text-center p-4']//h2 | //div[@class='text-center p-4']//p")
    private List<WebElement> productTabs;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getProductsText() {
        List<String> productTexts = new ArrayList<>();

        for (WebElement element : productTabs) {
            String text = element.getText().trim();
            if (text != null && !text.isEmpty() && !text.equalsIgnoreCase("Learn more")) {
                productTexts.add(text);
                logger.info("Extracted Text: " + text);
            } else if (text.equalsIgnoreCase("Learn more")) {
                //logger.info("Skipping 'Learn more' link text.");
            } else {
                logger.warn("Found empty or null text.");
            }
        }

        return productTexts;  // Return extracted text as a List
    }
}
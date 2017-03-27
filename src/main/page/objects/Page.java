package page.objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Driver;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static org.junit.Assert.assertTrue;


public class Page {

    public static final int POLLING_INTERVAL = 250;
    public static final int TIME_OUT = 5;
    private WebDriverWait wait;

    public Page() {
        wait = new WebDriverWait(Driver.getInstance(), TIME_OUT);
    }

    public boolean waitForPageToLoad() {
        ExpectedCondition<Boolean> documentIsReady = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                assertTrue("Driver was null. Please initiate Driver before executing method!", driver != null);
                return javascriptExecutor.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(documentIsReady);
    }

    public void waitForElementsToLoad(WebElement... element) {
        List<WebElement> listOfWebElement = new ArrayList<WebElement>();

        for (WebElement elementToAdd : element) {
            listOfWebElement.add(elementToAdd);
        }

        wait.pollingEvery(POLLING_INTERVAL, MICROSECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfWebElement));
    }


}

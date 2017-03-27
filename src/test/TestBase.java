

import org.junit.After;
import org.openqa.selenium.WebDriver;
import setup.Driver;

import static environment.EnvValues.JPET_STORE_ENV;
import static java.lang.System.out;

public class TestBase {

    private WebDriver driver;

    public void setupSelenium() {
        out.println("Starting browser");
        driver = Driver.getInstance();
        driver.navigate().to(JPET_STORE_ENV);
        driver.manage().window().maximize();
        out.print("Page launched with URL: " + JPET_STORE_ENV);
    }

    public void navigateToLandingPage() {
        driver.navigate().to(JPET_STORE_ENV);
    }

    @After
    public void tearDown() {
        Driver.tearDownDriver();
    }
}

package setup;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver instance;

    public static WebDriver getInstance() {
        if (instance == null) {
            ChromeDriverManager.getInstance().setup();
            instance = new ChromeDriver();
        }
        return instance;
    }

    public static void tearDownDriver() {
        instance.manage().deleteAllCookies();
        instance.close();
        instance.quit();
        instance = null;
    }
}

package Utulity;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;

    public static  WebDriverWait wait;

    static
    {


        KalanOncekileriKapat();

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);


         System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
         System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
         driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);

          driver.manage().timeouts().implicitlyWait(dr);


        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    }

    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }

    public static void driverBekleKapat()
    {
        MyFunc.bekle(3);
        driver.quit();
    }

}

package utilitiles;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DriverFactory {
    static WebDriver driver;
    static ChromeOptions cOptions = new ChromeOptions();
    static EdgeOptions eOptions = new EdgeOptions();

    public static WebDriver initiateDriver(String browserName,boolean headless, boolean maximize) {
        if (headless && browserName.equalsIgnoreCase("chrome")){
            cOptions.addArguments("headless");
            cOptions.addArguments("disable-gpu");
            cOptions.addArguments("no-sandbox");
        } else if (headless && browserName.equalsIgnoreCase("edge")) {
            eOptions.addArguments("headless");
            eOptions.addArguments("disable-gpu");
            eOptions.addArguments("no-sandbox");
        }
        if (browserName.equalsIgnoreCase("chrome")) {
            System.out.println("initializing Chrome Browser on OS: " + System.getProperty("os.name") + " and it's version is: " + System.getProperty("os.version"));
            driver = new ChromeDriver(cOptions);
            System.out.println("Successfully initialized the Chrome Browser");
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver(eOptions);
        }
        if (maximize) {
            driver.manage().window().maximize();
            System.out.println("Window is maximized. And the new window size is now: " + driver.manage().window().getSize());
        }
        return driver;

    }
}

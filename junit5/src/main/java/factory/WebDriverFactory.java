package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.openqa.selenium.remote.BrowserType.*;

public class WebDriverFactory {


    public static WebDriver getDriver(String browser){
        switch (browser) {
        case FIREFOX:
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        case EDGE:
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();

        case CHROME:
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        default: WebDriverManager.operadriver().setup(); return new OperaDriver();
    }
}


public static WebDriver getDriver(String browser, DesiredCapabilities options) {
    switch (browser) {
        case FIREFOX:
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(options);

        case EDGE:
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();

        case CHROME:
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(options);

        default: WebDriverManager.operadriver().setup(); return new OperaDriver(options);
    }

    }






}



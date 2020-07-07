import config.ServerConfig;
import factory.WebDriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;
import java.util.concurrent.TimeUnit;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)

public class OtusTest {
    WebDriver driver;
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    public Logger loggerTest = LogManager.getLogger(OtusTest.class);//for logs


    @BeforeEach
    public void setup() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("UnexpectedAlertBehaviour", "accept");
        ChromeOptions opt = new ChromeOptions();//to choose options
        opt.addArguments("start-fullscreen");
        caps.setCapability(ChromeOptions.CAPABILITY, opt);// post options using сapability

        String browser = System.getProperty("browser").toUpperCase();
        driver = WebDriverFactory.getDriver(browser, caps);

        //driver = WebDriverFactory.getDriver("chrome", caps);
        //driver.get(cfg.otus());

        loggerTest.info("Driver is set up");
        loggerTest.info("Open start page" + " " + cfg.otus());

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }


    @Test
    public void testLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("email", "password");

}

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }



}

package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
    protected WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    Logger loggerLogin = LogManager.getLogger(LoginPage.class);




    @FindBy(css = "input[type='text'].js-email-input")
    WebElement emailField;

    private final By passwordField = By.cssSelector("input[type='password']");
    private final By submitBtn = By.cssSelector("form[action='/login/'] button[type='submit']");


    public void login (String email, String password) {
        loggerLogin.info("Try to login");
        driver.findElement(By.cssSelector("button[data-modal-id='new-log-reg'].header2__auth")).click();
        emailField.sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitBtn).click();
        loggerLogin.info("Logged in");
    }



}

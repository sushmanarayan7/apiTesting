package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class DriverCreation {

    public static WebDriver chromeDriver;
    public static final String cdName = "webdriver.gecko.driver";
    public static final String cdPath = "geckodriver";

    @BeforeMethod
    public void setDriver(){

        System.setProperty(cdName, cdPath);
        chromeDriver = new FirefoxDriver();
//		chromeDriver.get(loginURL);
    }

    @AfterMethod
    public void afterTest()
    {
        chromeDriver.close();
    }
}
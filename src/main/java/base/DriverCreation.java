package base;

import com.jayway.restassured.RestAssured;
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
//      chromeDriver = new FirefoxDriver();
//		chromeDriver.get(loginURL);
        String baseHost = System.getProperty("server.host");
        if (baseHost==null)
        {
            baseHost= "https://api.coinsecure.in/v1";
        }
        RestAssured.baseURI=baseHost;
        System.out.println("Base URI is : " + RestAssured.baseURI);
    }

//    @AfterMethod
//    public void afterTest()
//    {
//        chromeDriver.close();
//    }
}
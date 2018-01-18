package AccountActions;

import base.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

import org.testng.annotations.*;
import com.jayway.restassured.RestAssured;

import javax.mail.MessagingException;

import static com.jayway.restassured.RestAssured.*;

public class LoginInitiateApi extends DriverCreation{


   Map<String,Object> jsonAsMap = new HashMap<>();
   RestAssured restAssured = new RestAssured();
   GetToken getToken = new GetToken();

    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","Data");

    }
    @Test(dataProvider="apiData")
 public void loginInitiate(String email,String password) throws Exception
    {
//        String baseHost = System.getProperty("server.host");
//        if (baseHost==null)
//        {
//            baseHost= "https://api.coinsecure.in/v1";
//        }
//        RestAssured.baseURI=baseHost;
//        System.out.println("Base URI is : " + RestAssured.baseURI);

       jsonAsMap.put("loginID",email);
       restAssured.given().
       contentType("application/json").
       baseUri(baseURI).
       body(jsonAsMap).
       when().post("/login/initiate").
       then().log().body();
  }
}
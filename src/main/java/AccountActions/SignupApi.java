package AccountActions;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.baseURI;

public class SignupApi extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","Data");
    }

    @Test(dataProvider="apiData")
    public void signupApi(String email, String password)
    {
//        String baseHost = System.getProperty("server.host");
//        if (baseHost==null)
//        {
//            baseHost= "https://api.coinsecure.in/v1";
//        }
//        RestAssured.baseURI=baseHost;
//        System.out.println("Base URI is : " + RestAssured.baseURI);


        Map<String,Object> jsonAsMap = new HashMap<>();
        RestAssured restAssured = new RestAssured();
        jsonAsMap.put("email",email);
        jsonAsMap.put("password", password);
        jsonAsMap.put("repeatPassword", password);
        jsonAsMap.put("refID", "123");
        restAssured.given().
                contentType("application/json").
                baseUri(baseURI).
                body(jsonAsMap).
                when().post("/signup").
                then().log().body();
    }
}

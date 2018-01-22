package AccountActions;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.baseURI;

public class SignupVerifyApi extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","Data");
    }

    @Test(dataProvider="apiData")
    public void signupVerify(String email, String password)throws Exception{
        Map<String,Object> jsonAsMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("Token-File.txt"));
        RestAssured restAssured = new RestAssured();
        GetToken getToken = new GetToken();
        getToken.getToken();
        String token = reader.readLine();
        jsonAsMap.put("token",token);
        jsonAsMap.put("email",email);
        restAssured.given().
                contentType("application/json").
                baseUri(baseURI).
                body(jsonAsMap).
                when().put("/signup/verify/").
                then().log().status();

    }
}

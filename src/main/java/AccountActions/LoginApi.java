package AccountActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.baseURI;

public class LoginApi extends DriverCreation
{

      GetToken getToken = new GetToken();
      RestAssured restAssured = new RestAssured();

      public void loginApi(String email, String password) throws Exception
      {
        BufferedReader reader = new BufferedReader(new FileReader("Token-File.txt"));
        getToken.getToken();
        String logintoken=reader.readLine();

        String token = "https://coinsecure.in/verifylogin/"+reader.readLine()+"?email="+email;
        System.out.println("Token to test Login API is : " +token);
            Map<String,Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email",email);
        jsonAsMap.put("token",token);
        jsonAsMap.put("password",password);
        jsonAsMap.put("gcmCode","123");
        jsonAsMap.put("pin","560045");
        restAssured.given().
                contentType("application/json").
                baseUri(baseURI).body(jsonAsMap).
                when().
                post("/login").
                then().log().body();
    }
}

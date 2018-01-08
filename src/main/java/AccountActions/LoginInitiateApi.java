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

//   @DataProvider(name = "apiData")
//    public Object[][] dataSource() {
//        return new String[][]{
//                {"testing12@coinsecure.in"}};
//    }

 //@Test()
 public RestAssured loginInitiate(String loginID) throws Exception {

       jsonAsMap.put("loginID",loginID);
       restAssured.given().
       contentType("application/json").
       baseUri(baseURI).
       body(jsonAsMap).
       when().post("/login/initiate").
       then().log().body();
       return restAssured;
  }

//@Test
  public RestAssured loginApi(String email, String password) throws Exception{
      BufferedReader reader = new BufferedReader(new FileReader("Token-File.txt"));
      getToken.getToken();
      String logintoken=reader.readLine();

      String token = "https://coinsecure.in/verifylogin/"+reader.readLine()+"?email="+email;
      System.out.println("Token to test Login API is : " +token);
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
      return restAssured;
}
}
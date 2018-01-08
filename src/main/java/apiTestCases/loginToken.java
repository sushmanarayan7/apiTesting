package apiTestCases;

import AccountActions.GetToken;
import AccountActions.LoginInitiateApi;
import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class loginToken extends DriverCreation
{
    @DataProvider(name = "apiLoginData")
    public Object[][] dataSource()
    {
        return new String[][]{
                {"testing12@coinsecure.in"}};
    }

    @Test(dataProvider = "apiLoginData")
    public void LoginTokenVerify(String email) throws Exception {

        LoginInitiateApi login=new LoginInitiateApi();
        login.loginInitiate(email);
        BufferedReader reader = new BufferedReader(new FileReader("Token-File.txt"));
        GetToken getToken = new GetToken();
        getToken.getToken();
        String logintoken=reader.readLine();
        System.out.println(logintoken);
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.pathParam("token",logintoken).queryParameter(email).get("/user/login/token/{token}");
        response.then().log().status();
        String str=response.jsonPath().get("message");
        System.out.println(str);
        if(str.equals("sushmanarayan7@gmail.com"))
        {
            System.out.println(str+" : Valid Token");
        }
        else{
            System.out.println(str+" : Invalid Token");
        }
    }
}

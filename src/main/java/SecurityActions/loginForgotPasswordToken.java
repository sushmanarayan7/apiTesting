package SecurityActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class loginForgotPasswordToken extends DriverCreation
{
    @Test
    public void ForgotPasswordTokenVerify()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.queryParameter("email","sushmanarayan7@gmail.com").pathParam("token","7912846128267390875230304").
                get("/login/password/forgot/verify/{token}");
        response.then().statusCode(200).log().status();
        response.getBody().print();
//        String str=response.jsonPath().getString("success");
//        if(str=="true")
//        {
//            String token=response.then().extract().path("message");
//            System.out.println("Token recieved for password reset : "+ token);
//        }
//        else{
//            String token=response.then().extract().path("message");
//            System.out.println(token);
//        }
    }
}

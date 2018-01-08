package apiTestCases;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.http.Method;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static locators.apiKey.apikey;
import static org.hamcrest.Matchers.equalTo;



public class apiTest extends DriverCreation {

    //    @Test
    public void api() {
        given().when().get("/home").then().statusCode(200).log().status();
//        given().when().get("/faq").then().assertThat().statusCode(200);
//        given().when().get("/faq").then().statusCode(200).log().headers();
        System.out.println("Successful Response");
    }


    @DataProvider(name = "apiData")
    public Object[][] dataSource() {
        return new String[][]{
                {"LaGTXdtMACLYviUe5Is6AB661Lslnded6BmX7eZD", "12345"}};
    }

    //{"LaGTXdtMACLYviUe5Is6AB661Lslnded6BmX7eZD",""},
//api testing for getting the bank otp
//@Test(dataProvider="apiData")
    public void apigetBankotp(String key, String phonenumber) {
        given().
                pathParam("number", phonenumber).
                parameter("key", key).
                header("Authorization", "{key}").
                when().
                get("/user/bank/otp/{number}").
                then().
                statusCode(200).log().status();
        System.out.println("Successful Response");
    }

    //api testing for getting the KYC otp
//@Test(dataProvider="apiData")
    public void apigetKYCotp(String key, String phonenumber) {
        given().
                pathParam("number", phonenumber).
                parameter("key", key).
                header("Authorization", "{key}").
                when().
                get("/user/kyc/otp/{number}").
                then().
                statusCode(200).log().status();
        System.out.println("Successful Response");
    }


    //api testing for getting the profile phone number otp
//@Test(dataProvider="apiData")
    public void apigetProfilephnotp(String key, String phonenumber) {
        given().
                pathParam("number", phonenumber).
                parameter("key", key).
                header("Authorization", "{key}").
                when().
                get("/user/profile/phone/otp/{number}").
                then().
                statusCode(200).log().status();
        System.out.println("Successful Response");
    }

    //    @Test(dataProvider="apiData")
    public void test(String key, String phonenumber) {
        String str = given().
                pathParam("number", phonenumber).
                parameter("key", key).
                header("Authorization", "{key}").
                then().
                get("/user/bank/otp/{number}").
//               getBody().asString();
        jsonPath().get("message");
        System.out.println(str);
        System.out.println("Successful Response");
    }



    @Test
    public void exchangeBanksummary()
    {
//        String str = given().when().header("Authorization", apikey).
//                then().get("/user/exchange/bank/summary").
//                jsonPath().get("message.bankLinkStatus");
////                getBody().print();
//        System.out.println("BankLinkStatus : " + str);
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/wallet/coin/withdraw/verified");
        response.then().statusCode(200).log().status();
        response.getBody().print();


//        String walletid=response.then().extract().path("message.walletID");
//        System.out.println(walletid);
//        String walletaddres=response.then().extract().path("message.address");
//        System.out.println(walletaddres);
//        String withdrawid=response.then().extract().path("message.withdrawID");
//        System.out.println(withdrawid);
//        String sentto=response.then().extract().path("message.sentTo");
//        System.out.println(sentto);

//        Assert.assertEquals(address1,"12DmVLt5T9a8dHFbtteensknb498a65HqD");
//        System.out.println("Address : "+address1);
//        .pathParam("walletID","ll1kvbH8C92dwdYlQURF")
    }
}
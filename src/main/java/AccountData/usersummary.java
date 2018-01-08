package AccountData;

import base.DriverCreation;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class usersummary extends DriverCreation
{
    @Test
    public void userSummary() {
        String str = given().
                header("Authorization", "LaGTXdtMACLYviUe5Is6AB661Lslnded6BmX7eZD").
                when().get("/user/summary").
                jsonPath().get("message.kycStatus");
//                getBody().print();
        System.out.println(str);
    }
}

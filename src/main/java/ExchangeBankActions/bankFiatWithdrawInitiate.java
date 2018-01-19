package ExchangeBankActions;

import base.DriverCreation;
import com.github.fge.jsonschema.core.keyword.syntax.checkers.draftv3.DraftV3ItemsSyntaxChecker;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

public class bankFiatWithdrawInitiate extends DriverCreation
{
    @Test
    public void FiatWithdrawInitiate()
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("fiat","10000");
        requestparms.put("account","201712345698752");
        requestparms.put("msg","Testing");
        requestparms.put("pin","");

        Response response=httpRequest.body(requestparms).header("Authorization","h947NqE3snlyWjznSVFW2UaBLRHzIS62CcY1KhjA").
                when().
                contentType(ContentType.JSON).
                post("/user/exchange/bank/fiat/withdraw/initiate");
        response.then().log().status();
        response.getBody().print();
    }
}

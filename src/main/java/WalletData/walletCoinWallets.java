package WalletData;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;


public class walletCoinWallets extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","apiKey");
    }


    @Test(dataProvider="apiData")
    public void CoinWallets(String key)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.parameter("key", key).header("Authorization","{key}").get("/user/wallet/coin/wallets");
        response.then().statusCode(200).log().status();
        response.getBody().print();
//        Integer val=response.jsonPath().getInt("count");
//        for(int i=0;i<val;i++)
//        {
//            String path= "message.walletID["+i+"]";
//            String walletid=response.then().extract().path(path);
//            System.out.println(walletid);
//        }
    }
}

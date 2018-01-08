package base;

import AccountActions.LoginInitiateApi;
import com.jayway.restassured.RestAssured;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class ExecuteTest
{
    public static void main(String[] args) throws Exception{

        String baseHost = System.getProperty("server.host");
        if (baseHost==null) {
//            baseHost = "https://coinsecure.in";
            baseHost= "https://api.coinsecure.in/v1";
        }
        RestAssured.baseURI=baseHost;
        System.out.println("Base URI is : " + RestAssured.baseURI);

        //Create object of TestNG Class//
        TestNG runner=new TestNG();
        // Create a list of String
        List<String> suitefiles=new ArrayList<String>();
        // Add xml file which you have to execute
        suitefiles.add("testng.xml");
        // now set xml file for execution
        runner.setTestSuites(suitefiles);
        // finally execute the runner using run method
        runner.run();

    }
}

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;


public class Extract_values_from_Response {

    @Test
    public void testResponse(){

        String response = get("https://restful-booker.herokuapp.com/booking/1").asString();
        System.out.println("Response is:"+ "\n"+response);


    }
}

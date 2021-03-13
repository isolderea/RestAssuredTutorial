import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;


public class Get_Tests {

    @Test
    public void HealthCheck(){
        get("https://restful-booker.herokuapp.com/ping");
    }

    @Test
    public void HealthCheckCode(){
        get("https://restful-booker.herokuapp.com/ping").then().statusCode(201);
    }

    @Test
    public void HealthCheckIncorrectCode(){
        get("https://restful-booker.herokuapp.com/ping").then().statusCode(200);
    }

    @Test
    public void CheckForContent(){
        get("https://restful-booker.herokuapp.com/booking").then().body(containsString("bookingid"));
    }

    @Test
    public void IncorrectCheckForContent(){
        get("https://restful-booker.herokuapp.com/booking").then().body(containsString("bookingsid"));
    }

    @Test
    public void CheckBodyNotEmpty(){
        get("https://restful-booker.herokuapp.com/booking").then().body("isEmpty()",Matchers.is(false));
    }

    @Test
    public void CheckBodyEmpty(){
        get("https://restful-booker.herokuapp.com/booking").then().body("isEmpty()",Matchers.is(true));
    }

    @Test
    public void CheckResponseHeader(){
        get("https://restful-booker.herokuapp.com/booking").then().header("Content-Type","application/json; charset=utf-8");
    }

    @Test
    public void CheckResponseHeaderJson(){
        get("https://restful-booker.herokuapp.com/booking").then().header("Content-Type","application/json");
    }


}

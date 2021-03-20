import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Map;

public class Customize_Body_Test {



    //Generate a token

    @BeforeTest
    public String getToken(){

        return given()
                .header("Content-Type", "application/json")
                .body("{\n    \"username\" : \"admin\",\n    \"password\" : \"password123\"\n}")
                .post("https://restful-booker.herokuapp.com/auth")
                .then()
                .extract().jsonPath().getString("token");

    }

    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
    }

    String tokenvalue = getToken();

    //Use the token to make an update
    @Test(priority = 1)
    public void UpdateBooking(){
        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token"+"="+tokenvalue)
                .body("{\n    \"firstname\" : \"ResterUpdate\",\n    " +
                        "\"lastname\" : \"TestUpdate\",\n    " +
                        "\"totalprice\" : 2500,\n    " +
                        "\"depositpaid\" : true,\n    " +
                        "\"bookingdates\" : {\n        " +
                        "\"checkin\" : \"2018-01-01\",\n        " +
                        "\"checkout\" : \"2019-01-01\"\n    " +
                        "},\n    " +
                        "\"additionalneeds\" : \"Breakfast\"\n}")
                .put("/1")
                .then()
                .statusCode(200);
    }


    //Get the information for the Booking that we changed and check if the changes where made
    @Test(priority = 2)
    public void GetUpdate(){
        get("/1").then().body(containsString("Rester"));
    }
}

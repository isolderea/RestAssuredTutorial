import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;


public class Put_Tests {

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

    String tokenvalue = getToken();

    //Use the token to make an update
    @Test
    public void UpdateBooking(){
            given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .header("Cookie", "token"+"="+tokenvalue)
                    .body("{\n    \"firstname\" : \"Rester\",\n    " +
                            "\"lastname\" : \"Test\",\n    " +
                            "\"totalprice\" : 111,\n    " +
                            "\"depositpaid\" : true,\n    " +
                            "\"bookingdates\" : {\n        " +
                            "\"checkin\" : \"2018-01-01\",\n        " +
                            "\"checkout\" : \"2019-01-01\"\n    " +
                            "},\n    " +
                            "\"additionalneeds\" : \"Breakfast\"\n}")
                    .put("https://restful-booker.herokuapp.com/booking/1")
                    .then()
                    .statusCode(200);
    }


    //Get the information for the Booking that we changed and check if the changes where made
    @Test
    public void GetUpdate(){
        get("https://restful-booker.herokuapp.com/booking/1").then().body(containsString("Rester"));
    }
}

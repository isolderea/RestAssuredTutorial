import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;


public class Delete_Tests {

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
                .header("Cookie", "token"+"="+tokenvalue)
                .delete("https://restful-booker.herokuapp.com/booking/2")
                .then()
                .statusCode(201);
    }


    //Get the information for the Booking that we changed and check if the changes where made
    @Test
    public void GetUpdate(){
        get("https://restful-booker.herokuapp.com/booking/2").then().statusCode(404);
    }
}

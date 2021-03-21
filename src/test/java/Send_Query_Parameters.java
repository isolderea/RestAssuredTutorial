import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;


public class Send_Query_Parameters {


    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking";
    }


    //Get all bookings
    @Test(priority = 1)
    public void getAllBookings(){

        Response response = given()
                .when()
                .get()
                .then().contentType("application/json")
                .extract()
                .response();
        String stringResponse = response.asString();
        System.out.println(stringResponse);
    }


    @Test(priority = 2)
    public void getBooking(){

        Response response = given()
                .when()
                .queryParam("postId", "1")
                .get("1")
                .then().contentType("application/json")
                .extract()
                .response();

        System.out.println("=============================Beginning of TEST 2 =================================");
        String stringResponse = response.asString();
        System.out.println(stringResponse);;
    }
}


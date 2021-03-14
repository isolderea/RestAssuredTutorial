import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;


public class Post_Tests {

    @Test
    public void CreateBooking(){

        //Given some setup
        //accepted header
        // body type
        //when you call the post endpoint
        // you will get a 200 Response back
        // your response will have a bookingid property

        given().
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"firstname\" : \"Jim\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 500,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}").
                post("https://restful-booker.herokuapp.com/booking").
                then().statusCode(200).
                and().
                body(containsString("bookingid"));

    }

}

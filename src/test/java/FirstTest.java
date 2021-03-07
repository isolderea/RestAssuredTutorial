import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FirstTest {


    @Test
    public void testStatusCode(){
        get("https://restful-booker.herokuapp.com/booking").then().statusCode(200);
    }


}

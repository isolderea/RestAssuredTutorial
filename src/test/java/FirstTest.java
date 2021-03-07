import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class FirstTest {


    @Test
    public void testStatusCode(){
        get("https://restful-booker.herokuapp.com/booking").then().statusCode(200);
    }


}

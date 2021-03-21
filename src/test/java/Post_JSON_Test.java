import javafx.scene.shape.Path;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;


public class Post_JSON_Test {

    @Test
    public void CreateBooking_MyData() throws IOException, ParseException {

        //Read the json file
        FileReader apireader = new FileReader("src/test/resources/custombody.json");
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(apireader);

        //Store the json in a variable
        String apiBody = object.toString();

        //Use the variable as the body

        given().
                header("Content-Type", "application/json").
                body(apiBody).
                post("https://restful-booker.herokuapp.com/booking").
                then().statusCode(200).
                and().
                body(containsString("bookingid"));

    }

}

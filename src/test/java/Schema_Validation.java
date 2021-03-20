import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class Schema_Validation {

    @Test
    public void schemaValidation(){

        given().
                when().
                get("https://restful-booker.herokuapp.com/booking/1").
                then().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                body(matchesJsonSchemaInClasspath("schema.json"));

    }
}

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class Save_Response_To_File {

    @Test
    public void save_to_json() throws IOException {

    //Save response as String
        String response =
                    given()
                    .when()
                    .get("https://restful-booker.herokuapp.com/booking/1")
                    .then().contentType("application/json")
                    .extract().asString();

    //Create a new Json File
        File fileObj = new File("response.json");

    //Error check
        if(fileObj.createNewFile()) {
            FileWriter myWriter = new FileWriter("response.json");
            myWriter.write(response);
            myWriter.close();
        }else {
            System.out.println("Failed");
        }


    }
}

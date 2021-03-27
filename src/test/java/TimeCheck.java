import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;


public class TimeCheck {

    @Test(priority = 1)
    public void timeCheck1(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .statusCode(200)
                .time(lessThan(200L));

    }

    @Test(priority = 2)
    public void timeCheck2(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .statusCode(200)
                .time(lessThan(200L),TimeUnit.NANOSECONDS);

    }


}


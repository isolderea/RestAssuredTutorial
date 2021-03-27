import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;


public class Log_log_and_log_again {

    @Test(priority = 1)
    public void noLOG(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .statusCode(200);

    }

    @Test(priority = 2)
    public void logRequest(){

        given()
                .when()
                .log().all()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .statusCode(200);

    }

    @Test(priority = 3)
    public void logResponse(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .log().all()
                .statusCode(200);

    }

    @Test(priority = 4)
    public void logBody1(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .log().body()
                .statusCode(200);

    }

    @Test(priority = 5)
    public void logBody2(){

        given()
                .when()
                .log().body()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .statusCode(200);

    }

    @Test(priority = 6)
    public void logStatus(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .log().status()
                .statusCode(200);

    }

    @Test(priority = 6)
    public void conditionalLog1(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .log().ifStatusCodeIsEqualTo(200)
                .statusCode(200);

    }

    @Test(priority = 7)
    public void conditionalLog2(){

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .log().ifError()
                .statusCode(200);

    }

    @Test(priority = 8)
    public void writeLogToFile() throws FileNotFoundException {
        PrintStream log = new PrintStream(new FileOutputStream("resterlog.txt"));


        given()
                .filter(RequestLoggingFilter.logRequestTo(log))
                .filter(ResponseLoggingFilter.logResponseTo(log))
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().contentType("application/json")
                .statusCode(200);

    }



}


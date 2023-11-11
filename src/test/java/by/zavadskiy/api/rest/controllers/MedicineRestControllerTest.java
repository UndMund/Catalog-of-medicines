package by.zavadskiy.api.rest.controllers;

import by.zavadskiy.annotation.IntegrationTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.hamcrest.Matchers.*;

@IntegrationTest
class MedicineRestControllerTest {
    @LocalServerPort
    private int port;

    @Test
    void getAllMedicines() {
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .get("http://localhost:" + port + "/api/v1/medicines")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(4));
    }


    @Test
    void addNewWrongMedicine() {
        String body = "{\n" +
                      "  \"name\": \"tablet1\"\n" +
                      "}";
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .post("http://localhost:" + port + "/api/v1/medicines")
                .then()
                .log().all()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("violations", hasSize(1));
    }

    @Test
    void addNewMedicine() {
        String body = "{\n" +
                      "  \"name\": \"Tablet\"\n" +
                      "}";
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .post("http://localhost:" + port + "/api/v1/medicines")
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
                .body("name", equalTo("Tablet"));
    }
}
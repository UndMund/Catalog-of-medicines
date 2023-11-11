package by.zavadskiy.api.rest.controllers;

import by.zavadskiy.annotation.IntegrationTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.hamcrest.Matchers.*;

@IntegrationTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PharmacyRestControllerTest {
    @LocalServerPort
    private int port;

    @Test
    void getAllPharmacies() {
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .get("http://localhost:" + port + "/api/v1/pharmacies")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void getAllPharmaciesByFilter() {
        String body = "{\n" +
                      "  \"medicineName\": \"tablet1\",\n" +
                      "  \"cityName\": \"Minsk\"\n" +
                      "}";

        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .get("http://localhost:" + port + "/api/v1/pharmacies/filter")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(2));
    }

    @Test
    void addNewWrongPharmacy() {
        String body = "{\n" +
                      "  \"name\": \"Pharmacy\",\n" +
                      "  \"city\": \"Minsk\",\n" +
                      "  \"street\": \"Berezova\",\n" +
                      "  \"houseNumber\": \"0\"\n" +
                      "}";
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .post("http://localhost:" + port + "/api/v1/pharmacies")
                .then()
                .log().all()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("violations", hasSize(1));
    }

    @Test
    void addNewPharmacy() {
        String body = "{\n" +
                      "  \"name\": \"Pharmacy\",\n" +
                      "  \"city\": \"Minsk\",\n" +
                      "  \"street\": \"Berezova\",\n" +
                      "  \"houseNumber\": \"10\"\n" +
                      "}";
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .post("http://localhost:" + port + "/api/v1/pharmacies")
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
                .body("name", equalTo("Pharmacy"));
    }

    @Test
    void addMedicineToPharmacy() {
        String body = "{\n" +
                      "  \"id\": \"1\"\n" +
                      "}";
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .patch("http://localhost:" + port + "/api/v1/pharmacies/2/medicines")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .body("medicinesDto", hasSize(1));
    }

    @Test
    void addWrongMedicineToPharmacy() {
        String body = "{\n" +
                      "  \"id\": \"10\"\n" +
                      "}";
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .patch("http://localhost:" + port + "/api/v1/pharmacies/2/medicines")
                .then()
                .log().all()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .body("errorCode", equalTo("medicine.not.found"));
    }

    @Test
    void addMedicineToWrongPharmacy() {
        String body = "{\n" +
                      "  \"id\": \"2\"\n" +
                      "}";
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .patch("http://localhost:" + port + "/api/v1/pharmacies/10/medicines")
                .then()
                .log().all()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .body("errorCode", equalTo("pharmacy.not.found"));
    }
}
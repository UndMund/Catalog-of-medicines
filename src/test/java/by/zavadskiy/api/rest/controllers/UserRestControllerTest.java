package by.zavadskiy.api.rest.controllers;

import by.zavadskiy.annotation.IntegrationTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@IntegrationTest
class UserRestControllerTest {
    @LocalServerPort
    private int port;

    @Test
    void registerWrongUser() {
        String body = "{\n" +
                      "  \"username\": \"User1\",\n" +
                      "  \"password\": \"User1\"\n" +
                      "}";
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .post("http://localhost:" + port + "/api/v1/users")
                .then()
                .log().all()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("violations", hasSize(2));
    }

    @Test
    void registerUser() {
        String body = "{\n" +
                      "  \"username\": \"Alexandr\",\n" +
                      "  \"password\": \"StrongPassword345\"\n" +
                      "}";
        RestAssured
                .given()
                .auth().basic("User1", "User11")
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .body(body)
                .post("http://localhost:" + port + "/api/v1/users")
                .then()
                .log().all()
                .statusCode(HttpStatus.CREATED.value())
                .body("username", equalTo("Alexandr"));
    }
}
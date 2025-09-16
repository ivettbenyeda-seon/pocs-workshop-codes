package com.seon.workshop.e2e;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.Matchers.equalTo;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WorkshopApplicationTests {

    @LocalServerPort
    private int port;

    private String getTestBaseUri()
    {return "http://localhost:" + this.port;}

    @Test
    void contextLoads() {
    }

    @Test
    void testCrawlSuccess() {
        String jsonBody = "{\"target_url\": \"https://www.vipm.lcom\"}";
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post(getTestBaseUri() + "/crawl");

        response.then()
                .statusCode(200).body("cached", equalTo(false));
    }

    @Test
    void testCrawlMissingTarget() {
        String jsonBody = "{}";
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post(getTestBaseUri() + "/crawl");

        response.then()
                .statusCode(400);
    }

    @Test
    void testCrawlInvalidTarget(){
        String jsonBody = "{\"target_url\": \"mkdw;q\"}";
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post(getTestBaseUri() + "/crawl");

        response.then()
                .statusCode(400);
    }

    @Test
    void testCrawlCached() {
        String jsonBody = "{\"target_url\": \"https://www.google.com\"}";
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post(getTestBaseUri() + "/crawl");
        response.then()
                .statusCode(200);
    }
}

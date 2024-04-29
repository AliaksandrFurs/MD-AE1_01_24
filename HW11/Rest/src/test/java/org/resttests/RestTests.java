package org.resttests;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class RestTests extends  BaseTest{

    @Test (description = "Test to validate status code 200")
    public void getStatusCode200Test(){

        ValidatableResponse response = given()
                .when()
                .get(BASE_URL + "/posts")
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchema(new File("src/test/java/resources/GetJsonSchema.json")));

        System.out.println(response.extract().asPrettyString());
    }

    @Test(description = "Test to validate header")
    public void validateResponseHeaderTest(){


        ValidatableResponse response = given()
                .when()
                .get(BASE_URL + "/posts")
                .then()
                .statusCode(200)
                .assertThat().header("Content-type", notNullValue())
                .assertThat().header("Content-Type", "application/json; charset=utf-8" );
    }

    @Test (description = "Test to validate body array count")
    public void validateResponseBodyTest(){

        ValidatableResponse respone = given()
                .get(BASE_URL + "/posts")
                .then()
                .statusCode(200)
                .body("size()", is(100));
        System.out.println(respone.extract().asPrettyString());
    }

    @Test(description = "Post test")
    public void createNewPostTest(){

        String requestBody = "{\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "}";

        ValidatableResponse response = given()
                .body(requestBody)
                .post(BASE_URL + "/posts")
                .then()
                .statusCode(201)
                .body("", notNullValue())
                .body(matchesJsonSchema(new File("src/test/java/resources/PostJsonSchema.json")));
        ResponseBody responseBody = response.extract().as(ResponseBody.class);
        System.out.println(responseBody.getId());
        System.out.println(response.extract().asPrettyString());

    }

    @Test (description = "Update post")
    public void updatePostTest(){

        ValidatableResponse respone = given()
                .put(BASE_URL + "/posts/1")
                .then()
                .statusCode(200)
                .body("id", is(1));

        System.out.println(respone.extract().asPrettyString());

    }

    @Test(description = "Delete post")
    public void deletePostTest(){

        ValidatableResponse response = given()
                .delete(BASE_URL + "/posts/1")
                .then()
                .statusCode(200);

        System.out.println(response.extract().asPrettyString());
    }

}

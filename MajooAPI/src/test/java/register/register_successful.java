package register;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class register_successful {
    @Test
    public void register_successful(ITestContext context){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("email", "eve.holt@reqres.in");
        bodyRequest.put("password", "pistol");

        request.body(bodyRequest.toString());
        request.header("Content-Type", "application/json");

        Response response = request.post("/api/register");
        String schemaPath = "src/resources/register_successful.json";

        System.out.printf(response.asString());
        response.then().assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
        System.out.println(response.asString());
    }
}
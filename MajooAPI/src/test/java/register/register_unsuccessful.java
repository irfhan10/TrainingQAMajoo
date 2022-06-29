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

public class register_unsuccessful {
    @Test
    public void register_unsuccessful(ITestContext context){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("email", "test@getnada.com");
        bodyRequest.put("password", "test123");

        request.body(bodyRequest.toString());
        request.header("Content-Type", "application/json");

        Response response = request.post("/api/register");
        String schemaPath = "src/resources/register_unsuccessful.json";

        response.then().assertThat()
                .statusCode(400)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
        System.out.println(response.asString());
    }
}
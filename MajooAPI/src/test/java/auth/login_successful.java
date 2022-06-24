package auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class login_successful {
    @Test
    public void login_successful(ITestContext context){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("email", "eve.holt@reqres.in");
        bodyRequest.put("password", "pistol");

        request.body(bodyRequest.toString());
        request.header("Content-Type", "application/json");

        Response response = request.post("/api/login");
        response.then().assertThat().statusCode(200);
        System.out.println(response.asString());
    }
}
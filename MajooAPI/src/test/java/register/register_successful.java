package register;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

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
        System.out.printf(response.asString());
        response.then().assertThat()
                .statusCode(200);
        System.out.println(response.asString());
    }
}
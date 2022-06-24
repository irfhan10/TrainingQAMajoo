package users;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createuser {
    @Test
    public void createuser(ITestContext context){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("name", "qwerty");
        bodyRequest.put("job", "quality assurance");

        request.body(bodyRequest.toString());
        request.header("Content-Type", "application/json");

        Response response = request.post("/api/users");
        response.then().assertThat()
                .statusCode(201)
                .body("name", Is.is("qwerty"))
                .body("job", Is.is("quality assurance"));
        System.out.println(response.asString());
    }
}
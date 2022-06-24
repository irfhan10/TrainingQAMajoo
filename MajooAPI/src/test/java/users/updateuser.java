package users;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class updateuser {
    @Test
    public void updateuser(ITestContext context){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("name", "testing");
        bodyRequest.put("job", "QA");

        request.body(bodyRequest.toString());
        request.header("Content-Type", "application/json");

        Response response = request.put("/api/users/2");
        response.then().assertThat()
                .statusCode(200)
                .body("name", Is.is("testing"))
                .body("job", Is.is("QA"));
        System.out.println(response.asString());
    }
}
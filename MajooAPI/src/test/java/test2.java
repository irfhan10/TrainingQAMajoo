import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test2 {
    @Test
    public void kedua(){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("name", "morpheus");
        bodyRequest.put("job", "leader");

        request.body(bodyRequest.toString());

        Response response = request.post("/api/users");
        response.then().assertThat().statusCode(201);
    }
}

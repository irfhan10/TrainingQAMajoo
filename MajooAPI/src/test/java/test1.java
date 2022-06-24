import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class test1 {
    @Test
    public void pertama(){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();

        Response response = request.get("/api/users");
        response.then().assertThat().statusCode(200);
    }
}

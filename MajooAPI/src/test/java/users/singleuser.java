package users;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class singleuser {
    @Test
    public void singleuser(ITestContext context){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();

        Response response = request.get("/api/users"+context.getAttribute("id_user"));
        response.then().assertThat().statusCode(200);

        System.out.println(response.asString());
    }
}
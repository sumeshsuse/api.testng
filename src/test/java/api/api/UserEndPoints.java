package api.api;

import api.payload.BookUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

    public static Response BookUser(BookUser bookUser){

        System.out.println("post url "+ Routes.post_url);

          Response response = given()
                   .contentType(ContentType.JSON)
                   .accept(ContentType.JSON)
                   .body(bookUser)
                   .when()
                   .post(Routes.post_url);
          return response;
    }


    public static Response getAllBookingDetails(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).when().get(Routes.get_url);

        return response;
    }

}

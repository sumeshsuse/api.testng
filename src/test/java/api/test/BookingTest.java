package api.test;

import api.api.UserEndPoints;
import api.payload.BookUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import com.fasterxml.jackson.databind.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class BookingTest {

    Faker faker;
    BookUser bookUserPayload;

    @BeforeClass
    public void setUpData(){
       faker = new Faker();
       bookUserPayload = new BookUser();

       HashMap<String, String> bookingDatesObj = new HashMap<String, String>();
       bookingDatesObj.put("checkin","2018-01-01");
       bookingDatesObj.put("checkout","2019-01-01");
       bookUserPayload.setFirstname("Jim");
       bookUserPayload.setLastname("Brown");
       bookUserPayload.setTotalprice(111);
       bookUserPayload.setDepositpaid(true);
       bookUserPayload.setBookingdates(bookingDatesObj);
       bookUserPayload.setAdditionalneeds("Breakfast");
    }

    @Test(priority = 1)
    public void testBookUser() throws JsonProcessingException {
        Response response = UserEndPoints.BookUser(bookUserPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void testAllBookingDetails(){
       Response response = UserEndPoints.getAllBookingDetails();
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(), 200);
    }
}

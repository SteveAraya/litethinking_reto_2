package reqres.users;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserRequest {

    public static Response getUserPage(RequestSpecification requestSpecification, String number){
        return requestSpecification.get("/api/users?page=" + number);
    }

    public static Response getUserID(RequestSpecification requestSpecification, String userID){
        return requestSpecification.get("/api/uses/" + userID);
    }

    public static Response postCreateNewUser(RequestSpecification requestSpecification, String userPayload){
        return requestSpecification.body(userPayload).post("/api/users");
    }
    
}

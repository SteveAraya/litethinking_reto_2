package reqres.delayedResponse;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DelayedResponseRequest {

    public static Response getDelayedResponseByDelayTime(RequestSpecification requestSpecification, String number){
        return requestSpecification.get("/api/users?delay=" + number);
    }
    
}

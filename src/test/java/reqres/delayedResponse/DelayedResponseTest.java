package reqres.delayedResponse;

import org.junit.jupiter.api.Test;

import io.restassured.response.Response;
import reqres.general.Questions;
import reqres.general.ReqresApiBase;

public class DelayedResponseTest extends ReqresApiBase{

    // Consumir el servicio "Delayed Response".
    @Test
    public void getDelayedResponse(){
        Response response = DelayedResponseRequest.getDelayedResponseByDelayTime(requestSpecification, "2");
        Questions.validateStatusCode(
            response,
            200
        );
        Questions.validateBodyParameterInt(
            response,
            "page",
            1
        );
        Questions.validateBodyParameterInt(
            response,
            "total_pages",
            2
        );
        Questions.validateJsonSchema(
            response,
            "reqres/UserPageJsonSchema.json"
        );
    }
  
}

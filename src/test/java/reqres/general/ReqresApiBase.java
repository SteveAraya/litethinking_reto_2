package reqres.general;

import org.junit.jupiter.api.BeforeEach;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.IConfigBase;

public class ReqresApiBase implements IConfigBase {

    protected RequestSpecification requestSpecification;

    @BeforeEach
    public void configure() {
        RestAssured.baseURI = "https://reqres.in";
        requestSpecification = RestAssured.given();
    }
    
}

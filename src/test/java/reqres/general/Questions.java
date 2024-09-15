package reqres.general;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Questions {

    public static void validateStatusCode(Response response, Integer statusCodeExpected) {
        assertEquals( 
            statusCodeExpected,
            response.statusCode(),
            "Validación del Status Code"
        );
    }

    public static void validateBodyParameterInt(Response response, String parameter, Integer value) {
        JsonPath jsonPath = new JsonPath( response.body().asString() );
        assertEquals( 
            value,
            jsonPath.getInt(parameter),
            "Validación del valor del parametro: " + parameter
        );
    }

    public static void validateBodyParameterString(Response response, String parameter, String value) {
        JsonPath jsonPath = new JsonPath( response.body().asString() );
        assertEquals( 
            value,
            jsonPath.getString(parameter),
            "Validación del valor del parametro: "  + parameter
        );
    }

    public static void validateJsonSchema(Response response, String jsonSchema){
        JsonSchemaValidator jsv = 
            JsonSchemaValidator.matchesJsonSchemaInClasspath(jsonSchema);

        assertTrue(
            "Validacion del Json Schema para Users Questions", 
            jsv.matches(response.asString())
        );
    }
    
}

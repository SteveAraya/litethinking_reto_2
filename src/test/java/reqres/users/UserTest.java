package reqres.users;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import io.restassured.response.Response;
import reqres.general.Questions;
import reqres.general.ReqresApiBase;

public class UserTest extends ReqresApiBase{

    // Consultar los usuarios de la página 2.
    @Test
    public void getUsersPage2(){
        Response response = UserRequest.getUserPage(requestSpecification, "2");
        Questions.validateStatusCode(
            response, 
            200
        );
        Questions.validateBodyParameterInt(
            response,
            "page",
            2
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

    // Consultar los datos del usuario 12.
    @Test
    public void getUserByID(){
        Response response = UserRequest.getUserID(requestSpecification, "12");
        Questions.validateStatusCode(
            response,
            200
        );
        Questions.validateJsonSchema(
            response,
            "reqres/UserJsonSchema.json"
        );
    }

    // Consultar los datos de un usuario inexistente.
    @Test
    public void getUserByIDNegative(){
        Response response = UserRequest.getUserID(requestSpecification, "0");
        Questions.validateStatusCode(
            response, 
            404
        );
        Questions.validateJsonSchema(
            response,
            "general/ErrorJsonSchema.json"
        );
    }

    // Crear un usuario.
    @ParameterizedTest
    @CsvSource({
        "Steve, SDET",
        "Maria, QA Manual",
        "Carlos,IT Support",
        "Ana, QA Automation"
    })
    public void createNewUser(String name, String job){
        String userPayload = ModelUser.userPayload( name, job);
        Response response = UserRequest.postCreateNewUser(requestSpecification, userPayload);
        Questions.validateStatusCode(
            response, 
            201
        );
        Questions.validateJsonSchema(
            response,
            "reqres/UserCreateJsonSchema.json"
        );
    }

}

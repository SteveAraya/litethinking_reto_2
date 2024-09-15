package reqres.users;

public class ModelUser {
    public static String userPayload(String name, String job){
        String json = "{"
        + "\"name\":\"" + name + "\","
        + "\"job\":\"" + job + "\""
        + "}";

        return json;
    }
}

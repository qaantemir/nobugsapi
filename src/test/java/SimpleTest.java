import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.Unicorn;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimpleTest {



    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/5511014ed2f24da7a96b2400efc48705";
    }

    @Test
    public void createUnicorn_test() throws JsonProcessingException {
        String responseBody = Unicorn.createUnicorn();

        JsonNode node = new ObjectMapper().readValue(responseBody, JsonNode.class);

        assertThat(responseBody, notNullValue());
        assertThat(node.isEmpty(), is(false));

    }

    @Test
    public void deleteUnicorn_test() throws JsonProcessingException {
        String postResponseBody = Unicorn.createUnicorn();

        JsonNode nodePost = new ObjectMapper().readValue(postResponseBody, JsonNode.class);
        String id = nodePost.get("_id").asText();

        Unicorn.deleteUnicorn(id);

        String getResponseBody = Unicorn.getUnicorn(id);

        JsonNode nodeGet = new ObjectMapper().readValue(getResponseBody, JsonNode.class);

//        System.out.println("----------------------------------------------------------------");
//        System.out.println(nodeGet.get("title"));
//        System.out.println("----------------------------------------------------------------");

        assertThat(nodeGet.get("status").asText(), equalTo("404"));

    }

    @Test
    public void updateUnicorn_test() throws JsonProcessingException {
        String postResponseBody = Unicorn.createUnicorn();
        JsonNode nodePost = new ObjectMapper().readValue(postResponseBody, JsonNode.class);
        String id = nodePost.get("_id").asText();

        Unicorn.changeUnicornColor(id, "blue");

        String getResponseBody = Unicorn.getUnicorn(id);
        JsonNode nodeGet = new ObjectMapper().readValue(getResponseBody, JsonNode.class);

        assertThat(nodeGet.get("color").asText(), equalTo("blue"));


    }

}
package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Unicorn {

    public static String createUnicorn() {
        return RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .body("{\n" +
                        "        \"name\": \"Nyashmyash\",\n" +
                        "        \"color\": \"black\"\n"
                )
                .when()
                    .post("/unicorns")
                .then()
                    .extract()
                    .response()
                    .body()
                    .asString();
    }

    public static void deleteUnicorn(String id) {
        RestAssured
                .given()
                .when()
                    .delete("/unicorns/" + id);
    }

    public static String getUnicorn(String id) {
        return RestAssured
                .given()
                .when()
                    .get("/unicorns" + "/" + id)
                .then()
                    .extract()
                    .response()
                    .body()
                    .asString();
    }

    public static String getUnicorns() {
        return RestAssured
                .given()
                .when()
                .get("/unicorns")
                .then()
                .extract()
                .response()
                .body()
                .asString();
    }

    public static void changeUnicornColor(String id, String color) {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body("{" +
                            "\"color\": \"" + color + "\"" +
                            "}")
                .when()
                    .put("/unicorns/" + id)
                .then()
                    .extract()
                    .response()
                    .body()
                    .asString();

    }
}

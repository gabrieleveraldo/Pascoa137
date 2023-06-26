package apiTest;


import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestePet {
    static String ct= "application/json";
    static String uriPet="https://petstore.swagger.io/v2/pet/";

    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }
    @Test
    public void testarIncluirPet ()throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/pet1.json");
        int petId = 1456789;

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uriPet)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(petId));
    }

    @Test
    public void testarConsultarPet ()throws IOException{
        int petId = 1456789;
        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriPet + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(petId))
        ;


    }
}



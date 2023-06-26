// nome do pacote
package apiTest;

// bibliotecas


import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

// classe
    public class TesteUser {
    // Atributos
    static String ct="application/json"; //content type
    static String uriUser="https://petstore.swagger.io/v2/user/";



    // Funções e métodos
    // Funções de apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
    return new String (Files.readAllBytes(Paths.get(arquivoJson)));
}


    //Funções de Teste
    @Test
    public void testarIncluirUser() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");

        String userId ="1375263253";

        //realizar o teste
        given()                                             //dado que
                .contentType(ct)                            //o tipo do conteudo
                .log().all()                               // mostre tudo
                .body(jsonBody)                           // corpo da requisição
        .when()                                           //quando
                      .post(uriUser)                      //Onde
        .then()                                           //então
                .log().all()                              // mostre tudo na volta
                .statusCode(200)                       //comunicação ida e volta está ok
                .body("code", is(200))           //tag code é 200
                .body("type", is("unknown"))      //tag type é "unknow"
                .body("message", is(userId));         //message é o userid
}
    @Test
    public void testarConsultarUser(){
        String username = "john";

        int userId = 1375263253;
        String email = "johnlovesyoko@teste.com";
        String senha = "ohyoko";
        String telefone = "11999998888";

        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriUser + username)

        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("email", is(email))
                .body("password", is(senha))
                .body("phone", is(telefone))
        ;
    }

    @Test
    public void testarAlterarUser() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");

        String userId ="1375263253";
        String userName = "john";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .put(uriUser + userName )
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userId))
        ;
    }

    @Test
    public void testarExcluirUser(){
        String username= "john";

        given()
                .contentType(ct)
                .log().all()
        .when()
                .delete(uriUser + username)
        .then()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(username))
        ;
    }

    @Test
    public void testarLogin() {
        String username = "john";
        String password = "paulmccartney";

        Response response = (Response) given()  //Usa o response para salvar a resposta
                 .contentType(ct)
                 .log().all()

        .when()
                 .get(uriUser + "login?username=" + username + "&password" + password)
        .then()
                    .log().all()
                    .statusCode(200)
                    .body("code", is(200))
                    .body("type", is("unknown"))
                    .body("message", containsString("logged in user session:"))
                    .body("message", hasLength(36))
                .extract()
        ;

        //Extração do token da resposta
        String token = response.jsonPath(). getString("message").substring(23);
        System.out.println("Conteúdo do Token: " + token);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/massaUser.csv", numLinesToSkip = 1, delimiter = ',')
    public void testarIncluirUserCSV(
            String id,
            String username,
            String firstname,
            String lastname,
            String email,
            String password,
            String phone,
            String userStatus)                              //pegar a estrutura Json e junta com os dados CSV
    {
        User user = new User();
        user.id = id;
        user.username = username;
        user.firstName = firstname;
        user.lastName = lastname;
        user.email = email;
        user.password = password;
        user. phone = phone;
        user.userStatus = userStatus;

        Gson gson = new Gson();
        String jsonBody = gson.toJson(user);

        //realizar o teste
        given()                                                 //dado que
                .contentType(ct)                               //o tipo do conteudo
                .log().all()                                  // mostre tudo
                .body(jsonBody)                               // corpo da requisição
        .when()                                              //quando
                .post(uriUser)                               //Onde
        .then()                                             //então
                .log().all()                               // mostre tudo na volta
                .statusCode(200)                        //comunicação ida e volta está ok
                .body("code", is(200))            //tag code é 200
                .body("type", is("unknown"))      //tag type é "unknow"
                .body("message", is(id));
    }

}

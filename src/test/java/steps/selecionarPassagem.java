package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selecionarPassagem {
WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("---remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown(){

    }


    @Given("que acesso o site Blazedemo")
    public void que_acesso_o_site_blazedemo() {
        System.out.println("Passo 1");
    }
    @When("seleciono a origem como {string} e destino {string}")
    public void seleciono_a_origem_como_e_destino(String string, String string2) {
        System.out.println("Passo 2");
    }
    @And("clico em Procurar Voo")
    public void clico_em_procurar_voo() {
        System.out.println("Passo 3");
    }
    @Then("é exibida a frase indicando voo entre {string} e {string}")
    public void é_exibida_a_frase_indicando_voo_entre_e(String string, String string2) {
        System.out.println("Passo 4");
    }
}

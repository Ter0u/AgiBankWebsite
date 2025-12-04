package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import config.DriverManager;
import logic.BuscaLogic;
import org.openqa.selenium.WebDriver;

public class BuscaSteps {

    private BuscaLogic buscaLogic;
    private WebDriver driver;

    @Given("que acesse ao AgiBlog")
    public void acesseBlogAgi() {
        DriverManager.abrirNavegador();
        driver = DriverManager.getDriver(); // pega o driver aberto
        buscaLogic = new BuscaLogic(driver);
    }

    @When("eu realizo a busca por {string} na barra de pesquisa")
    public void buscaBlogAgi(String pesquisa) throws InterruptedException {
        buscaLogic.clicarIconePesquisa();
        buscaLogic.digitarPesquisa(pesquisa);
    }

    @Then("o sistema deve exibir os resultados relacionados ao termo pesquisado")
    public void retornaBuscaComSucesso() {
        buscaLogic.verificarPrimeiroResultado();
    }

    @Then("a pesquisa deve me retornar {string}")
    public void retornaBuscaComFalha(String mensagemEsperada) {
        buscaLogic.validarMensagemResultado(mensagemEsperada);
    }
}
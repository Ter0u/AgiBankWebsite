package logic;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BuscaPage;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.Duration;

public class BuscaLogic {

    private final BuscaPage buscaPage;
    private final WebDriver driver;

    public BuscaLogic(WebDriver driver) {
        this.driver = driver;
        this.buscaPage = new BuscaPage(driver);
    }

    public void clicarIconePesquisa() throws InterruptedException {
        Thread.sleep(15000);
        buscaPage.getBtnSearch().click();
    }

    public void digitarPesquisa(String pesquisa) throws InterruptedException {
        buscaPage.getSearchInput().sendKeys(pesquisa);
        Thread.sleep(15000);
    }

    public boolean isResultadoVisivel(int timeoutSegundos) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSegundos));
            wait.until(ExpectedConditions.visibilityOf(buscaPage.getResults()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void verificarPrimeiroResultado() {
        assertTrue(isResultadoVisivel(15));
    }

    public void validarMensagemResultado(String mensagemEsperada) {
        boolean resultadoVisivel = isResultadoVisivel(15);
        String mensagemAtual = buscaPage.getResults().getText();
        assertTrue("O resultado não apareceu na página!", resultadoVisivel);

        assertEquals("Mensagem exibida na página não corresponde à esperada!\nEsperado: "
                + mensagemEsperada + "\nAtual: " + mensagemAtual, mensagemAtual, mensagemEsperada);
    }
}

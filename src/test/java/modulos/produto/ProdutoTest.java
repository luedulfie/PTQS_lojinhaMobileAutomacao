package modulos.produto;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import paginas.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Módulo de Produto")
public class ProdutoTest {
    private WebDriver app;
    private DesiredCapabilities capacidades;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        // É necessario definir as caracteristicas necessárias para o Appium
        this.capacidades =  new DesiredCapabilities();
        capacidades.setCapability("deviceName", "Samsung S20 FE");
        capacidades.setCapability("platform", "Android");
        capacidades.setCapability("udid", "RQ8R6003KCX");
        capacidades.setCapability("appPackage", "com.lojinha");
        capacidades.setCapability("appActivity", "com.lojinha.ui.MainActivity");
        capacidades.setCapability("app", "C:\\Users\\lucas\\IdeaProjects\\lojinhaMobileAutomacao\\lojinha_android_nativa\\lojinha-nativa.apk");

        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        app.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DisplayName("Validação do Valor de Produto Não Permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido() {
        String mensagemApresentada = new LoginPage(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .selecionarEntrar()
                .selecionarCadastrarProduto()
                .preencherNomeProduto("iPhoneAppium")
                .preencherValorProduto("700001")
                .preencherCorProduto("preto, cinza")
                .selecionarSalvarNovoProdutoComErro()
                .capturarMensagemErro();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @AfterEach()
    public void afterEach() {
        app.quit();
    }
}

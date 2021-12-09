package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaProdutosPage extends BasePage {

    public ListaProdutosPage(WebDriver app) {
        super(app);
    }

    public FormularioAdicaoProdutoPage selecionarCadastrarProduto() {
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();

        return new FormularioAdicaoProdutoPage(app);
    }
}

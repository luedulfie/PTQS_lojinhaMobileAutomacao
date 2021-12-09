package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicaoProdutoPage extends BasePage{

    public FormularioAdicaoProdutoPage(WebDriver app) {
        super(app);
    }

    public FormularioAdicaoProdutoPage preencherNomeProduto(String nomeProduto) {
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(nomeProduto);

        return this;
    }

    public FormularioAdicaoProdutoPage preencherValorProduto(String valorProduto) {
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(valorProduto);

        return this;
    }

    public FormularioAdicaoProdutoPage preencherCorProduto(String corProduto) {
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(corProduto);

        return this;
    }

    public FormularioAdicaoProdutoPage selecionarSalvarNovoProdutoComErro() {
        app.findElement(By.id("com.lojinha:id/saveButton")).click();

        return this;
    }

    public String capturarMensagemErro() {
        return capturarToast();
    }
}

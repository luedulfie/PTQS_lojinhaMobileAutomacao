package paginas;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver app) {
        super(app);
    }

    public LoginPage preencherUsuario(String usuario) {
        app.findElement(By.id("com.lojinha:id/user")).click();
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys(usuario);

        return this;
    }

    public LoginPage preencherSenha(String senha) {
        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys(senha);

        return this;
    }

    public ListaProdutosPage selecionarEntrar() {
        app.findElement(By.id("com.lojinha:id/loginButton")).click();

        return new ListaProdutosPage(app);
    }
}

package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver app;

    public BasePage (WebDriver app) {
        this.app = app;
    }

    public String capturarToast() {
        return app.findElement(By.xpath("//android.widget.Toast")).getText();
    }
}

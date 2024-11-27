package testcontext;

import org.openqa.selenium.WebDriver;

/**
 * A classe TestContext: Armazena o WebDriver. Permite que o mesmo WebDriver
 * seja reutilizado por várias partes do teste. Centraliza a lógica de
 * inicialização e acesso ao WebDriver.
 * <p>
 * Objetivo do Código O objetivo da classe TestContext é facilitar o
 * compartilhamento da instância do WebDriver entre diferentes partes do seu
 * teste (por exemplo, diferentes step definitions no Cucumber). Isso elimina a
 * necessidade de recriar o WebDriver várias vezes, o que economiza recursos e
 * garante que o estado do navegador seja consistente durante o teste.
 * <p>
 * Porque escolhi usar TestContext?
 * <p>
 * Foi a solução que escolhi de forma a partilhar estados entre Steps
 * definitions para cada feature que estou a testar. Assim, é mais fácil
 * reutilizar o código, em vez de estar sempre a criar Uma instância do
 * webdriver separadamente.
 */
public class TestContext {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

}



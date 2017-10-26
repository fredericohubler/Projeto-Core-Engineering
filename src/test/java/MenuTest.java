import org.junit.Test;
import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void testaMenuInicial(){
        //given
        String esperado = "";
        esperado = "Bem vindo ao sistema.\n";
        esperado += "Selecione a opção desejada:\n";
        esperado += "1 - Entrar com usuário já existente.\n";
        esperado += "2 - Criar novo usuário.";

        //when
        Menu menu = new Menu();
        String resultado = menu.menuInicial();

        //then
        assertEquals(esperado, resultado);
    }
}

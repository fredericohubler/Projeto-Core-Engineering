
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.*;

import java.sql.ResultSet;


public class DatabaseTest {

    @Test
    public void retornaConexaoComSucesso(){
        //given
        String esperado = "STATUS--->Conectado com sucesso!";

        //when
        Database.getConexaoMySQL();
        String retorno = Database.status;

        //then
        assertEquals(esperado,retorno);
    }

    @Test
    public void testaRecuperaBanco(){
        //given
        String esperado1 = "Teste";
        String esperado2 = "Teste2";
        int esperado3 = 1234;
        int esperado4 = 4321;

        //when
        User u = new User("Teste",1234);
        User v = new User("Teste2",4321 );
        u.insereBanco();
        v.insereBanco();
        String sql = "SELECT User.Nome FROM User";

        String retorno1,retorno2;
        int retorno3,retorno4;
        retorno1 = Database.retornaNomeUsers().get(0);
        retorno2 = Database.retornaNomeUsers().get(1);
        retorno3 = Database.retornaCpfUsers().get(0);
        retorno4 = Database.retornaCpfUsers().get(1);
        u.removeBanco();
        v.removeBanco();

        //then
        assertEquals(esperado1,retorno1);
        assertEquals(esperado2,retorno2);
        assertEquals(esperado3,retorno3);
        assertEquals(esperado4,retorno4);

    }
}

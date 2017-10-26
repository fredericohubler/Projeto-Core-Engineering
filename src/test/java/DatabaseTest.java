import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseTest {

    private DatabaseDAO databaseDAO = new DatabaseDAO();
    private UserDAO userDAO = new UserDAO();

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
        String esperado3 = "1234";
        String esperado4 = "4321";

        //when
        User u = new User("Teste","1234");
        User v = new User("Teste2","4321" );
        userDAO.insereBanco(u);
        userDAO.insereBanco(v);
        String sql = "SELECT User.Nome FROM User";

        String retorno1,retorno2;
        String retorno3,retorno4;
        retorno1 = databaseDAO.retornaNomeUsers().get(0);
        retorno2 = databaseDAO.retornaNomeUsers().get(1);
        retorno3 = databaseDAO.retornaCpfUsers().get(0);
        retorno4 = databaseDAO.retornaCpfUsers().get(1);
        userDAO.removeBanco(u);
        userDAO.removeBanco(v);

        //then
        assertEquals(esperado1,retorno1);
        assertEquals(esperado2,retorno2);
        assertEquals(esperado3,retorno3);
        assertEquals(esperado4,retorno4);

    }
}

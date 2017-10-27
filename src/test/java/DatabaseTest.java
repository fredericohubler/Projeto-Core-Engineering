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
        String esperado1 = "Teste1";
        String esperado2 = "Teste2";
        String esperado3 = "11111111111";
        String esperado4 = "22222222222";

        //when
        User mockUser1 = new User("Teste1","11111111111");
        User mockUser2 = new User("Teste2","22222222222" );
        userDAO.insere(mockUser1);
        userDAO.insere(mockUser2);
        String sql = "SELECT User.Nome FROM User";

        String retorno1,retorno2;
        String retorno3,retorno4;
        retorno1 = databaseDAO.retornaNomeUsers().get(0);
        retorno2 = databaseDAO.retornaNomeUsers().get(1);
        retorno3 = databaseDAO.retornaCpfUsers().get(0);
        retorno4 = databaseDAO.retornaCpfUsers().get(1);
        userDAO.remove(mockUser1);
        userDAO.remove(mockUser2);

        //then
        assertEquals(esperado1,retorno1);
        assertEquals(esperado2,retorno2);
        assertEquals(esperado3,retorno3);
        assertEquals(esperado4,retorno4);

    }
}

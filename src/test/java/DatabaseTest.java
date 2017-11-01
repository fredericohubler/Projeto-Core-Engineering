import dao.DatabaseDAO;
import dao.UserDAO;
import model.Database;
import model.User;
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
        String esperado3 = "11111111112";
        String esperado4 = "22222222221";

        //when
        User mockUser1 = new User("Teste1","11111111112");
        User mockUser2 = new User("Teste2","22222222221" );
        userDAO.insere(mockUser1);
        userDAO.insere(mockUser2);
        String sql = "SELECT model.User.Nome FROM model.User";

        String retorno1 = null;
        String retorno2 = null;
        String retorno3 = null;
        String retorno4 = null;
        for (int i = 0; i <databaseDAO.retornaNomeUsers().size() ; i++) {
            if(databaseDAO.retornaNomeUsers().get(i).equals("Teste1")){
                retorno1 = databaseDAO.retornaNomeUsers().get(i);
            }
            if(databaseDAO.retornaNomeUsers().get(i).equals("Teste2")){
                retorno2 = databaseDAO.retornaNomeUsers().get(i);
            }

            if(databaseDAO.retornaCpfUsers().get(i).equals("11111111112")){
                retorno3 = databaseDAO.retornaCpfUsers().get(i);
            }

            if(databaseDAO.retornaCpfUsers().get(i).equals("22222222221")){
                retorno4 = databaseDAO.retornaCpfUsers().get(i);
            }
        }
        userDAO.remove(mockUser1);
        userDAO.remove(mockUser2);


        //then
        assertEquals(esperado1,retorno1);
        assertEquals(esperado2,retorno2);
        assertEquals(esperado3,retorno3);
        assertEquals(esperado4,retorno4);

    }
}

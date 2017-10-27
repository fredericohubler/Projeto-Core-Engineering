
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private UserDAO userDAO = new UserDAO();
    @Test
    public void testaInsereBanco(){
        //when
        User u = new User("Teste", "11111111111");
        boolean retorno= userDAO.insere(u);
        userDAO.remove(u);
        //then
        assertTrue(retorno);
    }

    @Test
    public void testaRemoveBanco(){
        //when
        User u = new User("Teste","11111111111");
        boolean retorno = userDAO.remove(u);

        //then
        assertTrue(retorno);
    }
}

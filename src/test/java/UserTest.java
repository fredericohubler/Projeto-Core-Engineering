
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private UserDAO userDAO = new UserDAO();
    @Test
    public void testaInsereBanco(){
        //when
        User u = new User("Teste", "1234");
        boolean retorno= userDAO.insereBanco(u);
        userDAO.removeBanco(u);
        //then
        assertTrue(retorno);
    }

    @Test
    public void testaRemoveBanco(){
        //when
        User u = new User("Teste","1234");
        boolean retorno = userDAO.removeBanco(u);

        //then
        assertTrue(retorno);
    }
}


import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void testaInsereBanco(){
        //when
        User u = new User("Teste", 1234);
        boolean retorno= u.insereBanco();
        u.removeBanco();
        //then
        assertTrue(retorno);
    }

    @Test
    public void testaRemoveBanco(){
        //when
        User u = new User("Teste",1234);
        boolean retorno = u.removeBanco();

        //then
        assertTrue(retorno);
    }
}

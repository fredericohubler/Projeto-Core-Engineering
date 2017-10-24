
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void testaInsereBanco(){
        //when
        User u = new User("Teste");
        boolean retorno= u.insereBanco();

        //then
        assertTrue(retorno);
    }
}

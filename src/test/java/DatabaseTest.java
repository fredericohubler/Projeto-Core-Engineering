
import org.junit.Test;

import static org.junit.Assert.*;


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
}

import dao.UserDAO;
import model.Conta;
import model.ContaDAO;
import model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContaTest {

    private ContaDAO contaDAO = new ContaDAO();
    private UserDAO userDAO = new UserDAO();

    @Test
    public void testaInsereBanco(){
        //when
        User mockUser = new User("Teste", "11111111112");
        userDAO.insere(mockUser);
        Conta mockConta = new Conta("0257", "3520538006", 0.0, 5.0, "ContaTeste", "12", mockUser.getCPF());
        boolean retorno= contaDAO.insere(mockConta);
        contaDAO.remove(mockConta);
        userDAO.remove(mockUser);
        //then
        assertTrue(retorno);
    }
}

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {

    public boolean insere(Conta conta){
        String insert="INSERT INTO Conta(NumeroConta, Saldo, Mensalidade, Nome, DiaMensalidade, Agencia, UserCPF) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(insert);
            prep.setString(1,conta.getNumeroConta());
            prep.setDouble(2,conta.getSaldo());
            prep.setDouble(3,conta.getMensalidade());
            prep.setString(4,conta.getNome());
            prep.setString(5,conta.getDiaMensalidade());
            prep.setString(6,conta.getAgencia());
            prep.setString(7,conta.getUserCPF());
            prep.execute();
            prep.close();
            return true;
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }

    public boolean remove(Conta conta) {
        String insert="DELETE FROM Conta WHERE NumeroConta = ?";
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(insert);
            prep.setString(1,conta.getNumeroConta());
            prep.execute();
            prep.close();
            return true;
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }
}

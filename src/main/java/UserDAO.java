import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public boolean insereBanco(User user) {
        String insert="INSERT INTO User(Nome, CPF) VALUES (?, ?)";
        try{
            PreparedStatement prep = Database.getConnection().prepareStatement(insert);
            prep.setString(1,user.getNome());
            prep.setString(2,user.getCPF());
            prep.execute();
            prep.close();
            return true;
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }

    public boolean removeBanco(User user) {
        String insert="DELETE FROM User WHERE CPF = ?";
        try{
            PreparedStatement prep = Database.getConnection().prepareStatement(insert);
            prep.setString(1,user.getCPF());
            prep.execute();
            prep.close();
            return true;
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }
}

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseDAO {



    public ArrayList<String> retornaNomeUsers(){
        String sql = "SELECT User.Nome FROM User";
        ArrayList<String> retorno= new ArrayList<>();
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(sql);
            ResultSet st = prep.executeQuery();
            while (st.next()){
                retorno.add(st.getString("Nome"));
            }
        }catch (SQLException u){
            throw new RuntimeException(u);
        }

        return retorno;
    }

    public ArrayList<String> retornaCpfUsers(){
        String sql = "SELECT User.CPF FROM User";
        ArrayList<String> retorno= new ArrayList<>();
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(sql);
            ResultSet st = prep.executeQuery();
            while (st.next()){
                retorno.add(st.getString("CPF"));
            }
        }catch (SQLException u){
            throw new RuntimeException(u);
        }
        return retorno;
    }
}

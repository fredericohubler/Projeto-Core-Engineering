package dao;

import model.Database;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public boolean insere(User user) {
        String insert="INSERT INTO User(Nome, CPF) VALUES (?, ?)";
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(insert);
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

    public boolean remove(User user) {
        String insert="DELETE FROM User WHERE CPF = ?";
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(insert);
            prep.setString(1,user.getCPF());
            prep.execute();
            prep.close();
            return true;
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }

    public String retornarNome(User user){
        String insert="SELECT Nome FROM User WHERE CPF = ?";
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(insert);
            prep.setString(1,user.getCPF());
            ResultSet st = prep.executeQuery();
            st.next();
            return st.getString("Nome");
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }

    public String retornarCPF(User user){
        String insert="SELECT CPF FROM User WHERE CPF = ?";
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(insert);
            prep.setString(1,user.getCPF());
            ResultSet st = prep.executeQuery();
            st.next();
            return st.getString("CPF");
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }
}

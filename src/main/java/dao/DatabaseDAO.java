package dao;

import model.Conta;
import model.Database;

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

    public ArrayList<String> retornaNumeroContas(){
        String sql = "SELECT Conta.NumeroConta FROM Conta";
        ArrayList<String> retorno= new ArrayList<>();
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(sql);
            ResultSet st = prep.executeQuery();
            while (st.next()){
                retorno.add(st.getString("NumeroConta"));
            }
        }catch (SQLException u){
            throw new RuntimeException(u);
        }
        return retorno;
    }

    public ArrayList<String> retornaNumeroContaUsuarioEspecifico(String cpfUser){
        String sql = "SELECT Conta.NumeroConta FROM Conta WHERE UserCPF = ?";
        ArrayList<String> retorno= new ArrayList<>();
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(sql);
            prep.setString(1,cpfUser);
            ResultSet st = prep.executeQuery();
            while (st.next()){
                retorno.add(st.getString("NumeroConta"));
            }
        }catch (SQLException u){
            throw new RuntimeException(u);
        }
        return retorno;
    }

    public Conta retornaObjetoConta(String numeroConta){
        String sql= "SELECT * FROM Conta WHERE NumeroConta = ?";
        ResultSet st;
        try{
            PreparedStatement prep = Database.getConexaoMySQL().prepareStatement(sql);
            prep.setString(1, numeroConta);
            st = prep.executeQuery();
            st.next();
            Conta retorno = new Conta(st.getString("Agencia"), st.getString("NumeroConta"), st.getDouble("Saldo"),st.getDouble("Mensalidade"),st.getString("Nome"),st.getString("DiaMensalidade"),st.getString("UserCPF"));
            return retorno;
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }
}

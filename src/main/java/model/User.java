package model;

import java.util.ArrayList;
import java.sql.Connection;
public class User {
    private ArrayList<Conta> contas;
    private String nome;



    private String cpf;
    private Database db = new Database();
    private Connection connection;

    public User(String nome, String cpf){
        this.nome=nome;
        this.cpf=cpf;
        contas = new ArrayList<Conta>();
        this.connection = Database.getConexaoMySQL();
    }

    /*public void adicionaConta(String agencia, int numConta, double saldo, double mensalidade, String nome, String diaMensalidade){
        model.Conta nova = new model.Conta(agencia, numConta, saldo, mensalidade, nome, diaMensalidade);
        contas.add(nova);
    }*/


    public String getNome() {
        return nome;
    }

    public String getCPF() { return cpf; }

    public ArrayList<Conta> getContas() {
        return contas;
    }

   /* public boolean insere() {
        String insert="INSERT INTO model.User(Nome, CPF) VALUES (?, ?)";
        try{
            PreparedStatement prep = connection.prepareStatement(insert);
            prep.setString(1,getNome());
            prep.setString(2,getCPF());
            prep.execute();
            prep.close();
            return true;
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }

    public boolean remove() {
        String insert="DELETE FROM model.User WHERE CPF = ?";
        try{
            PreparedStatement prep = connection.prepareStatement(insert);
            prep.setString(1,getCPF());
            prep.execute();
            prep.close();
            return true;
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }*/


}

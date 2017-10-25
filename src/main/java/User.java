import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
public class User {
    private ArrayList<Conta> contas;
    private String nome;



    private int cpf;
    private Database db = new Database();
    private Connection connection;

    public User(String nome, int cpf){
        this.nome=nome;
        this.cpf=cpf;
        contas = new ArrayList<Conta>();
        this.connection = Database.getConexaoMySQL();
    }

    public void adicionaConta(String agencia, int numConta, double saldo, double mensalidade, String nome, String diaMensalidade){
        Conta nova = new Conta(agencia, numConta, saldo, mensalidade, nome, diaMensalidade);
        contas.add(nova);
    }


    public String getNome() {
        return nome;
    }

    public int getCPF() { return cpf; }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public boolean insereBanco() {
        String insert="INSERT INTO User(Nome, CPF) VALUES (?, ?)";
        try{
            PreparedStatement prep = connection.prepareStatement(insert);
            prep.setString(1,getNome());
            prep.setString(2,Integer.toString(getCPF()));
            prep.execute();
            prep.close();
            return true;
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }

    public boolean removeBanco() {
        String insert="DELETE FROM User WHERE CPF = ?";
        try{
            PreparedStatement prep = connection.prepareStatement(insert);
            prep.setString(1,Integer.toString(getCPF()));
            prep.execute();
            prep.close();
            return true;
        } catch (SQLException u){
            System.out.println(u);
            throw new RuntimeException(u);
        }
    }


}

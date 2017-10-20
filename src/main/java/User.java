import java.util.ArrayList;
public class User {
    private ArrayList<Conta> contas;
    private String nome;

    public User(String nome){
        this.nome=nome;
        contas = new ArrayList<Conta>();
    }

    public void adicionaConta(String agencia, int numConta, double saldo, double mensalidade, String nome, String diaMensalidade){
        Conta nova = new Conta(agencia, numConta, saldo, mensalidade, nome, diaMensalidade);
        contas.add(nova);
    }


    public String getNome() {
        return nome;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }


}

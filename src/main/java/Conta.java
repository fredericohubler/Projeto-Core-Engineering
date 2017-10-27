import java.util.ArrayList;

public class Conta {

    private double saldo, mensalidade;
    private String nome, diaMensalidade, agencia, userCPF, numeroConta;
    private ArrayList<CartaoCredito> listaCartoes;

    public Conta(String agencia, String numConta, double saldo, double mensalidade, String nome, String diaMensalidade, String userCPF) {
        this.agencia = agencia;
        this.numeroConta = numConta;
        this.saldo = saldo;
        this.mensalidade = mensalidade;
        this.nome = nome;
        this.diaMensalidade = diaMensalidade;
        this.userCPF=userCPF;
        listaCartoes = new ArrayList<CartaoCredito>();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getDiaMensalidade() {
        return diaMensalidade;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getUserCPF() {
        return userCPF;
    }

    public String Resumo() {
        return "    " + nome + "\nAgencia: " + agencia + "\nNumero da conta: " + numeroConta + "\nSaldo: " + saldo + "\nMensalidade: " + mensalidade + "\nDia da Mensalidade: " + diaMensalidade + "\nCartoes de credito: " + listaCartoes.size();
    }

    public void adicionaCartaoCredito(int numeroCartao, String validade, String diaFatura, String bandeira, double saldo, double limite) {
        CartaoCredito novo = new CartaoCredito(numeroCartao, validade, diaFatura, bandeira, saldo, limite);
        listaCartoes.add(novo);
    }

    public ArrayList<CartaoCredito> getListaCartoes() {
        return listaCartoes;
    }

    public void removeCartaoCredito(String numero) {
        for (int i = 0; i < listaCartoes.size(); i++) {
            if (listaCartoes.get(i).getNumeroCartao() == Integer.parseInt(numero)) {
                listaCartoes.remove(i);
                return;
            }
        }
        System.out.println("Cartão nao encontrado.");
    }

    public String printaCartoes() {
        String retorno = "";
        for (int i = 0; i < listaCartoes.size(); i++) {
            retorno = retorno + "\n\n" + listaCartoes.get(i).resumo();
        }
        return retorno;
    }
}
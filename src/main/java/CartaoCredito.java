public class CartaoCredito {
    private int numeroCartao;
    private String validade, diaFatura, bandeira;
    private double saldo, limite;

    public CartaoCredito(int numeroCartao, String validade, String diaFatura, String bandeira, double saldo, double limite) {
        this.numeroCartao = numeroCartao;
        this.validade = validade;
        this.diaFatura = diaFatura;
        this.bandeira = bandeira;
        this.saldo = saldo;
        this.limite = limite;
    }

    public String resumo(){
        return "Numero do Cartão: "+numeroCartao+"\nValidade: "+validade+"\nDia da Fatura: "+diaFatura+"\nBandeira: "+bandeira+"\nSaldo: "+saldo+"\nLimite: "+limite;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }
}

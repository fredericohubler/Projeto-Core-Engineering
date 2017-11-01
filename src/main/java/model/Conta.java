package model;

import java.util.ArrayList;

public class Conta {

    private double saldo, mensalidade;
    private String nome, diaMensalidade, agencia, userCPF, numeroConta;

    public Conta(String agencia, String numConta, double saldo, double mensalidade, String nome, String diaMensalidade, String userCPF) {
        this.agencia = agencia;
        this.numeroConta = numConta;
        this.saldo = saldo;
        this.mensalidade = mensalidade;
        this.nome = nome;
        this.diaMensalidade = diaMensalidade;
        this.userCPF=userCPF;
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

}
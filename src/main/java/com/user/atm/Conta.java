package com.user.atm;

import com.user.atm.utils.Utils;

public class Conta {

    private static int accountCounter = 100101;

    private int numero;
    private Pessoa pessoa;
    private double saldo = 0.0;

    public Conta(Pessoa p) {
        this.numero = accountCounter;
        this.pessoa = p;
        accountCounter += 1;
    }

    public int getNumeroDigito() {
        return numero;
    }

    public void setNumeroDigito(int numero) {
        this.numero = numero;
    }

    public Pessoa getCorrentista() {
        return pessoa;
    }

    public void setCorrentista(Pessoa p) {
        this.pessoa = p;
    }

    public double obterSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nNúmero da conta: " + this.getNumeroDigito() + "\nNome: " + this.pessoa.getNome() + "\nCPF: " + this.pessoa.getDocumento() + "\nEmail: " + this.pessoa.getEmail() + "\nSaldo: " + Utils.doubleToString(this.obterSaldo()) + "\n";
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            setSaldo(obterSaldo() + valor);
            System.out.println("\n\nSaldo atualizado.");
            return true;
        } else {
            System.out.println("Não foi possível realizar o depósito");
            return false;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && this.obterSaldo() >= valor) {
            setSaldo(obterSaldo() - valor);
            System.out.println("\n\nSaldo atualizado.");
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque");
            return false;
        }
    }

    public boolean transferir(Conta contaDeposito, double valor) {
        if (valor > 0 && this.obterSaldo() >= valor) {

            setSaldo(obterSaldo() - valor);

            contaDeposito.saldo = contaDeposito.obterSaldo() + valor;
            System.out.println("\n\nSaldo atualizado.");
            return true;

        } else {
            return false;
        }

    }


}

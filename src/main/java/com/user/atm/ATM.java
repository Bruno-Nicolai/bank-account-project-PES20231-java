package com.user.atm;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        menuInicial();
    }

    private static void menuInicial() {

        System.out.println("\n                   Bem vindo!                   ");
        System.out.println("************ Selecione uma operação ************");
        System.out.println("\n\n             1. Abrir conta_____________________");
        System.out.println("             2. Acessar conta___________________");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                menuAbrirConta();
                break;

            case 2:
                menuSenha();
                break;

            default:
                System.out.println("\nOpção inválida!");
                menuInicial();
                break;
        }
    }

    public static void menuAbrirConta() {

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        System.out.println("\nSenha: ");
        String senha = input.next();

        Pessoa p = new Pessoa(nome, cpf, email, senha);

        Conta c = new Conta(p);
        contasBancarias.add(c);
        System.out.println("\n\n--- Sucesso! Sua conta é " + c.getNumeroDigito() + ". Guarde o dígito da conta para acessar o sistema posteriormente. ---");

        menuInicial();

    }

    private static void menuSenha() {
        OperacaoBanco operacaoBanco = new OperacaoBanco();
        System.out.println("\nDígito da conta: ");
        int numero = input.nextInt();

        if (!operacaoBanco.validarConta(numero)) {
            System.out.println("Conta não encontrada");
            menuSenha();
        }

        System.out.println("\nSenha: ");
        String senha = input.next();

        if (operacaoBanco.validarSenha(numero, senha)) {
            menuOpcoes(numero);
        } else {
            System.out.println("Senha inválida");
            menuSenha();
        }
    }

    public static void menuOpcoes(int numero) {
        OperacaoBanco operacaoBanco = new OperacaoBanco();

        System.out.println("********* " + operacaoBanco.buscaContaPorNumero(numero).obterSaldo() + " | Selecione uma operação *******");
        System.out.println("\n\n             1. Depositar_______________________");
        System.out.println("             2. Sacar___________________________");
        System.out.println("             3. Transferir______________________");
        System.out.println("             0. Sair____________________________\n");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                menuDeposito(numero);
                break;

            case 2:
                menuSaque(numero);
                break;

            case 3:
                menuTransferencia(numero);
                break;

            case 0:
                System.out.println("\nObrigado por escolher nossos serviços. Volte sempre!");
                menuInicial();
                break;

            default:
                System.out.println("\nOpção inválida!");
                menuOpcoes(numero);
                break;
        }
    }

    public static void menuDeposito(int numero) {
        OperacaoBanco operacaoBanco = new OperacaoBanco();
        Conta conta = operacaoBanco.buscaContaPorNumero(numero);

        System.out.println("\nValor a depositar: ");
        double valorDeposito = input.nextDouble();

        if (operacaoBanco.depositarNaConta(conta, valorDeposito)) {
            menuOpcoes(numero);
        } else {
            System.out.println("\nFalha ao realizar depósito.");
        }

        menuOpcoes(numero);
    }

    public static void menuSaque(int numero) {
        OperacaoBanco operacaoBanco = new OperacaoBanco();
        Conta conta = operacaoBanco.buscaContaPorNumero(numero);

        System.out.println("\nValor a sacar: ");
        double valorSaque = input.nextDouble();

        if (operacaoBanco.sacarDaConta(conta, valorSaque)) {
            menuOpcoes(numero);
        } else {
            System.out.println("\nFalha ao realizar saque.");
        }

        menuOpcoes(numero);
    }

    public static void menuTransferencia(int numero) {
        OperacaoBanco operacaoBanco = new OperacaoBanco();
        Conta conta = operacaoBanco.buscaContaPorNumero(numero);

        System.out.println("\nNúmero da conta do destinatário: ");
        int numeroDestinatario = input.nextInt();
        Conta contaDestinatario = operacaoBanco.buscaContaPorNumero(numeroDestinatario);

        if (conta != contaDestinatario) {
            System.out.println("\nValor da transferência: ");
            double valorTransferencia = input.nextDouble();
            double saldo = operacaoBanco.buscaContaPorNumero(numero).obterSaldo();
            if (operacaoBanco.transferirParaOutraConta(conta, contaDestinatario, valorTransferencia) && valorTransferencia >= saldo && saldo != 0) {
                menuOpcoes(numero);
            } else {
                System.out.println("\nFalha ao realizar transferência.");
            }
        } else {
            System.out.println("\nVocê não pode tranferir para si mesmo.");
        }

        menuOpcoes(numero);
    }

}

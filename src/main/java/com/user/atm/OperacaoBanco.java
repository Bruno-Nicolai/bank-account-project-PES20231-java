package com.user.atm;

import static com.user.atm.ATM.contasBancarias;

public class OperacaoBanco {

    public Conta buscaContaPorNumero(int numero) {
        Conta c = null;
        if (!contasBancarias.isEmpty()) {
            for (Conta conta : contasBancarias) {
                if (conta.getNumeroDigito() == numero) {
                    c = conta;
                }
            }
        }
        return c;
    }

    public boolean validarConta(int numero) {
        for (int i = 0; i < contasBancarias.size(); i++) {
            if (contasBancarias.get(i).getNumeroDigito() == numero) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validarSenha(int numero, String senha) {
        for (int i = 0; i < contasBancarias.size(); i++) {
            if (contasBancarias.get(i).getCorrentista().getSenha().equals(senha)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean depositarNaConta(Conta conta, double valorDeposito) {

        if (conta != null) {
            conta.depositar(valorDeposito);
            return true;
        } else {
            System.out.println("\n\nConta não encontrada");
            return false;
        }

    }

    public boolean sacarDaConta(Conta conta, double valorSaque) {

        if (conta != null) {
            conta.sacar(valorSaque);
            return true;
        } else {
            System.out.println("\n\nConta não encontrada");
            return false;
        }

    }

    public boolean transferirParaOutraConta(Conta conta, Conta contaDestinatario, double valorTransferencia) {
        if (conta != null) {
            if (contaDestinatario != null && conta != contaDestinatario) {
                conta.transferir(contaDestinatario, valorTransferencia);
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("\n\nConta não encontrada");
            return false;
        }
    }

}

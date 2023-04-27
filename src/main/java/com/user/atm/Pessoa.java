package com.user.atm;

public class Pessoa {
    
    private static int counter = 1;
    private String nome, documento, email, senha;


    public Pessoa(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.documento = cpf;
        this.email = email;
        this.senha = senha;
        counter += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    @Override
    public String toString() {
        return  "\nNome: "+this.getNome()+"\nCPF: "+this.getDocumento()+"\nEmail: "+this.getEmail();
    }
    
}

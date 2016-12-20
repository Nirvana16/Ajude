package br.edu.iff.pooa20162.ajude.model;

/**
 * Created by Nirvana161 on 19/12/16.
 */

public class Contato {

    private String nome;
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato(){
        nome = "Fulando de tal";
        telefone = "+5522997814310";
    }




}

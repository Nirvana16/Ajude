package br.edu.iff.pooa20162.ajude.model;

import com.orm.SugarRecord;

/**
 * Created by Nirvana16 on 19/12/16.
 */

public class Contato extends SugarRecord{

    private Long id;

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
    }

    public Contato(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }




}

package br.edu.iff.pooa20162.ajude.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Nirvana161 on 19/12/16.
 */

public class Paciente extends SugarRecord {

    private Long id;
    private String nome;
    private String dataNascimento;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Paciente(String nome, String dataNascimento, String telefone){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Paciente(){}





}

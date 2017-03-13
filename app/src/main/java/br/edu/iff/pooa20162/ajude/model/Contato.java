package br.edu.iff.pooa20162.ajude.model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Nirvana16 on 19/12/16.
 */

public class Contato extends SugarRecord{

    private Long id;

    private String nome;
    private String telefone;

    private Mensagem mensagem;

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

//    public List<Mensagem> getMensagem(){
//        return Mensagem.find(Mensagem.class, "contato = ?", new String{contato.getId()});
//    }

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
        //mensagem = new Mensagem();
    }




}

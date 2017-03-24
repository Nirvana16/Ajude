package br.edu.iff.pooa20162.ajude.model;

import com.orm.SugarRecord;

/**
 * Created by Nirvana161 on 19/12/16.
 */

public class Exame extends SugarRecord{
    private String descricao, data, hora;

    public Exame( String descricao, String data, String hora){
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }
    public Exame(){    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}

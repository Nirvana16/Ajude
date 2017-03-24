package br.edu.iff.pooa20162.ajude.model;

import com.orm.SugarRecord;

/**
 * Created by Nirvana161 on 19/12/16.
 */

public class Medicamento extends SugarRecord{

    private String nome, descricao, horaDeUso;
    //Colocando data do tipo string, depois irei implementar para ficar do tipo Date
    private String dataInicio, dataTermino;
    private int dosagem;


    public  Medicamento (String nome, String descricao, String horaDeUso, String dataInicio, String dataTermino, int dosagem){
        this.nome = nome;
        this.descricao = descricao;
        this.horaDeUso = horaDeUso;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.dosagem = dosagem;
    }
    public  Medicamento (){}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHoraDeUso() {
        return horaDeUso;
    }

    public void setHoraDeUso(String horaDeUso) {
        this.horaDeUso = horaDeUso;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }

}

package br.edu.iff.pooa20162.ajude.model;

import com.orm.SugarRecord;

/**
 * Created by boris on 23/12/16.
 */

public class Opcoes extends SugarRecord {


    private long id;
    private boolean tocaAlarme = true;
    private boolean notificaMedicamento = true;
    private boolean excluiExame = false;
    private int quantidadeMsg = 4;

    public int getQuantidadeMsg() {
        return quantidadeMsg;
    }

    public void setQuantidadeMsg(int quantidadeMsg) {
        this.quantidadeMsg = quantidadeMsg;
    }

    public boolean isTocaAlarme() {
        return tocaAlarme;
    }

    public void setTocaAlarme(boolean tocaAlarme) {
        this.tocaAlarme = tocaAlarme;
    }

    public boolean isNotificaMedicamento() {
        return notificaMedicamento;
    }

    public void setNotificaMedicamento(boolean notificaMedicamento) {
        this.notificaMedicamento = notificaMedicamento;
    }

    public boolean isExcluiExame() {
        return excluiExame;
    }

    public void setExcluiExame(boolean excluiExame) {
        this.excluiExame = excluiExame;
    }


}

package br.edu.iff.pooa20162.ajude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContatoActivity extends AppCompatActivity {

 // Variaveis locais ====================================================================
//    private String nome = "Fulando de tal", telefone = "+5522997814310";
    private String nome, telefone;

 // Getters and Setters ================================================================
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

// Metodos construtores =================================================================
    /* Fiz atribuição estatica por ora. futuramente isso sera coletado do usuario e
        em seguida do banco de dados.
    */
    public ContatoActivity(){
        nome = "Fulando de tal";
        telefone = "+5522997814310";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
    }
}

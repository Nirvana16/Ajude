package br.edu.iff.pooa20162.ajude.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.ajude.R;
import br.edu.iff.pooa20162.ajude.model.Exame;
import br.edu.iff.pooa20162.ajude.model.Medicamento;


/**
 * Created by nirvana161 on 22/03/17.
 */

public class ExameAdapter extends ArrayAdapter<Exame> {

    private Context context = null;
    private ArrayList<Exame> exames = null;

    public ExameAdapter(Context context, ArrayList<Exame> exames) {
        super(context, R.layout.linha_exame,exames);
        this.context = context;
        this.exames = exames;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha_exame, parent, false);

        TextView descricao = (TextView) rowView.findViewById(R.id.tvExameDescricao);
        descricao.setText(exames.get(position).getDescricao());

        TextView data = (TextView) rowView.findViewById(R.id.tvDataExame);
        data.setText(exames.get(position).getData());

        TextView hora = (TextView) rowView.findViewById(R.id.tvHoraDoExame);
        hora.setText(exames.get(position).getHora());


        return rowView;
    }
}
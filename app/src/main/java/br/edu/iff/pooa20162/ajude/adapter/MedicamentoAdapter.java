package br.edu.iff.pooa20162.ajude.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.ajude.R;
import br.edu.iff.pooa20162.ajude.model.Medicamento;

/**
 * Created by nirvana161 on 22/03/17.
 */

public class MedicamentoAdapter extends ArrayAdapter<Medicamento> {

    private Context context = null;
    private ArrayList<Medicamento> medicamentos = null;

    public MedicamentoAdapter(Context context, ArrayList<Medicamento> medicamentos) {
        super(context, R.layout.linha_medicamento,medicamentos);
        this.context = context;
        this.medicamentos = medicamentos;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha_medicamento, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.tvLinhaMedicamento);
        nome.setText(medicamentos.get(position).getNome());
        return rowView;
    }
}
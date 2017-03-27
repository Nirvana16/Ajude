package br.edu.iff.pooa20162.ajude.mask;

/**
 * Created by Nirvana16 on 22/12/16.
 */

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.HashSet;
import java.util.Set;

public class MascaraEditTextListener implements TextWatcher{

    private static MascaraEditTextListener instance;

    private String mascara;
    private EditText editText;
    private Set<String> SymbolMask = new HashSet<String>();
    private boolean estaAtualizando;
    private String old = "";

    public MascaraEditTextListener(String mask, EditText editText) {
        mascara = mask;
        this.editText = editText;
        initSymbolMask();
    }

    private void initSymbolMask(){
        for (int i = 0; i < mascara.length(); i++){
            char ch = mascara.charAt(i);
            if (ch != '#')
                SymbolMask.add(String.valueOf(ch));
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String str = Utils.unmask(s.toString(), SymbolMask);
        String mascara = "";

        if (estaAtualizando) {
            old = str;
            estaAtualizando = false;
            return;
        }

        if(str.length() > old.length())
            mascara = Utils.mask(this.mascara,str);
        else
            mascara = s.toString();

        estaAtualizando = true;

        editText.setText(mascara);
        editText.setSelection(mascara.length());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void afterTextChanged(Editable s) {

    }
}
package com.example.jlavado.pruebafirebase;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class AlumnoHolder extends RecyclerView.ViewHolder {
    TextView txtdni,txtnombres,txtedad, txtestado;
    CardView lista;

    public AlumnoHolder (View itemView){
        super(itemView);
        lista = (CardView) itemView.findViewById(R.id.listadatos);
        txtdni=(TextView) itemView.findViewById(R.id.item_dni);
        txtnombres=(TextView) itemView.findViewById(R.id.item_nombres);
        txtedad=(TextView) itemView.findViewById(R.id.item_edad);
        txtestado=(TextView) itemView.findViewById(R.id.item_estado);
    }

    public void setTxtdni(String dni) {
        txtdni.setText(dni);
    }

    public void setTxtnombres(String nombres) {
        txtnombres.setText(nombres);
    }

    public void setTxtedad(int edad) {
        txtedad.setText(edad+"");
    }

    public void setTxtestado(String estado) {
        txtestado.setText(estado);
    }

    public CardView getLista() {
        return lista;
    }
}

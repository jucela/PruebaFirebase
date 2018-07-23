package com.example.jlavado.pruebafirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ingreso_alumnos extends AppCompatActivity {
    EditText edtdni ;
    EditText edtnombres;
    EditText edtedad;
    EditText edtestado;
    Button   btningresar;
    Button   btnlistar;
    Query query;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingreso_alumnos);
        edtdni =     (EditText) findViewById(R.id.edtdni);
        edtnombres = (EditText) findViewById(R.id.edtnombres);
        edtedad =    (EditText) findViewById(R.id.edtedad);
        edtestado =  (EditText) findViewById(R.id.edtestado);
        btningresar = (Button)  findViewById(R.id.btningresar);
        btnlistar = (Button) findViewById(R.id.btnlistar);



        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtdni.getText().toString().equals("") && !edtnombres.getText().toString().equals("") ){
                    Alumno alumno = new Alumno(edtdni.getText().toString(),edtnombres.getText().toString(),Integer.parseInt(edtedad.getText().toString()),edtestado.getText().toString());
                    FirebaseFirestore.getInstance().collection("alumnos").document(edtdni.getText().toString())
                            .set(alumno)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("FIRESTORE", "DocumentSnapshot successfully written!");
                                    Toast.makeText(ingreso_alumnos.this,"Datos Guardados Correctamente",Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w("FIRESTORE", "Error writing document", e);
                                    Toast.makeText(ingreso_alumnos.this,"Error al guardar datos",Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                else {
                    Toast.makeText(ingreso_alumnos.this,"Hay Campos Vacios",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ingreso_alumnos.this,listado_alumnos.class);
                startActivity(intent);
                finish();
            }
        });


    }
}

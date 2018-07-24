package com.example.jlavado.pruebafirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class listado_alumnos extends AppCompatActivity{

    RecyclerView recyclerView;
    Button btnregresar;
    Query query;
    FirestoreRecyclerAdapter adapter;
    FirestoreRecyclerOptions<Alumno> options;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_alumnos);
        recyclerView =(RecyclerView) findViewById(R.id.recycler);
        btnregresar = (Button) findViewById(R.id.btnregresar);

        query = FirebaseFirestore.getInstance().collection("alumnos").whereEqualTo("estado","casado");

        options = new FirestoreRecyclerOptions.Builder<Alumno>()
                .setQuery(query, Alumno.class)
                .build();
        adapter = new FirestoreRecyclerAdapter<Alumno,AlumnoHolder>(options) {
            @Override
            public void onBindViewHolder(AlumnoHolder holder, int position, Alumno model) {
                holder.setTxtdni(model.getDni());
                holder.setTxtnombres(model.getNombres());
                holder.setTxtedad(model.getEdad());
                holder.setTxtestado(model.getEstado());
            }

            @Override
            public AlumnoHolder onCreateViewHolder(ViewGroup group, int i) {
                // Create a new instance of the ViewHolder, in this case we are using a custom
                // layout called R.layout.message for each item
                View view = LayoutInflater.from(group.getContext()).inflate(R.layout.lista, group, false);
                return new AlumnoHolder(view);
            }
        };
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listado_alumnos.this,ingreso_alumnos.class);
                startActivity(intent);
                finish();
            }
        });





    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }



}

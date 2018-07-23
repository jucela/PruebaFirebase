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
    Query query;
    FirestoreRecyclerAdapter adapter;
    FirestoreRecyclerOptions<Alumno> options;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_alumnos);
        recyclerView =(RecyclerView) findViewById(R.id.recycler);
//
//        query = FirebaseFirestore.getInstance().collection("alumnos").whereEqualTo("estado",edtestado);
//
//        options = new FirestoreRecyclerOptions.Builder<Alumno>()
//                .setQuery(query, Alumno.class)
//                .build();
//        adapter = new FirestoreRecyclerAdapter<Alumno, PersonaHolder>(options) {
//            @Override
//            public void onBindViewHolder(PersonaHolder holder, int position, Persona model) {
//                holder.setTxtDni(model.getDni());
//                holder.setTxtNombre(model.getNombre());
//                holder.setTxtSalon(model.getSalon());
//            }
//
//            @Override
//            public PersonaHolder onCreateViewHolder(ViewGroup group, int i) {
//                // Create a new instance of the ViewHolder, in this case we are using a custom
//                // layout called R.layout.message for each item
//                View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_layout, group, false);
//                return new PersonaHolder(view);
//            }
//        };
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);



    }




}

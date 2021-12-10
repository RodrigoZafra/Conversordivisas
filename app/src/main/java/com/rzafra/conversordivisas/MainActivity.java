package com.rzafra.conversordivisas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MiAdaptador adapter;
    private EditText etCantidad;
    private TextView tvResultado;
    private RecyclerView recyclerView;
    MiAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCantidad = findViewById(R.id.EtCantidad);
        tvResultado = findViewById(R.id.tvResultado);

        ArrayList<String> divisasNames = new ArrayList<>();
        divisasNames.add("USD");
        divisasNames.add("GBP");
        divisasNames.add("CAD");
        divisasNames.add("JPY");
        divisasNames.add("INR");
        divisasNames.add("NZD");
        divisasNames.add("CHF");
        divisasNames.add("ZAR");
        divisasNames.add("RUB");

        recyclerView = findViewById(R.id.rvDivisas);
        LinearLayoutManager mLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);
        adapter = new MiAdaptador(this, divisasNames);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                mLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
    //Este metodo convierte la cantidad a la divisa seleccionada en el recyclerView
    public void Convertir(View view) {
        Double cantidad = Double.parseDouble(etCantidad.getText().toString());
        if (recyclerView.equals("USD")) {
            tvResultado.setText(cantidad * 1.1293946 + "");
        }else{
            tvResultado.setText("Error");
        }
    }
}
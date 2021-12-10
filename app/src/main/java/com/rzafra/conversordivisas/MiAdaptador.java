package com.rzafra.conversordivisas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder>{
    private List<String> mData;
    private LayoutInflater mInflater;
    private int pos = 0;

    public int getPos() {
        return this.pos;
    }
    MiAdaptador(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    //Crea los nuevos objetos ViewHolder necesarios para los elementos de la colección
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    //Actualiza los datos de un ViewHolder ya existente
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String divisa = mData.get(position);
        holder.myTextView.setText(divisa);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            //Este onClick nos permite que cuando pulsamos un campo del recycler se ponga de un color y se quite al volverlo a pulsar
            @Override
            public void onClick(View view) {
                TextView myTV = view.findViewById(R.id.tvDivisas);
                ColorDrawable viewColor = (ColorDrawable) myTV.getBackground();

                if (viewColor == null) myTV.setBackgroundColor(Color.BLACK);
                else {
                    int colorId = viewColor.getColor();
                    if (colorId == Color.WHITE) myTV.setBackgroundColor(Color.BLACK);
                    else myTV.setBackgroundColor(Color.WHITE);
                }
                pos = position;
            }
        });
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;

        ViewHolder(View itemView){
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvDivisas);
        }
    }
}

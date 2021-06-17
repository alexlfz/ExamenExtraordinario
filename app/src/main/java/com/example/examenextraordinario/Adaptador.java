package com.example.examenextraordinario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private List<ArrayList<String>> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    Adaptador(Context context){
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<ArrayList<String>>();
    }

    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_adaptador, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        ArrayList<String> linea = mData.get(position);
        holder.tvId.setText(linea.get(0));
        holder.tvLanguage.setText(linea.get(1));
        holder.tvEdition.setText(linea.get(2));
        holder.tvAuthor.setText(linea.get(3));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public void addData(ArrayList<ArrayList<String>> info) {
        mData.addAll(info);
        notifyDataSetChanged();
    }

    ArrayList<String> getItem(int id) {
        return mData.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvId;
        TextView tvLanguage;
        TextView tvEdition;
        TextView tvAuthor;

        ViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.txtId);
            tvLanguage = itemView.findViewById(R.id.txtLanguage);
            tvEdition = itemView.findViewById(R.id.txtEdition);
            tvAuthor = itemView.findViewById(R.id.txtAuthor);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


}
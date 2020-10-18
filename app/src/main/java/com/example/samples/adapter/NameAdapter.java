package com.example.samples.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samples.R;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

    private List<String> names;

    public NameAdapter(List<String> names) {
        this.names = names;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(names.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder {
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void setName(String name) {
            TextView textView = itemView.findViewById(R.id.name);
            textView.setText(name);
        }
    }
}

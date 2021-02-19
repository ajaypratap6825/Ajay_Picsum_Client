package com.example.projects.picsum;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private List<Data> uploads;

    public DataAdapter(List<Data> uploads) {
        this.uploads = uploads;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.list, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.DataViewHolder holder, int position) {
        Data data = uploads.get(position);
        String url = "https://picsum.photos/300/300?image=" + data.getId();
        Picasso.get().load(url).fit().centerCrop().into(holder.image);
        holder.name.setText(data.getAuthor());
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }
}

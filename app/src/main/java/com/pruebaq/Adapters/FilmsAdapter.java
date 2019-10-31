package com.pruebaq.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pruebaq.Models.Film;
import com.pruebaq.R;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder>
{
    Context context;
    List<Film> filmList;

    public FilmsAdapter (Context context, List<Film> filmList)
    {
        this.context = context;
        this.filmList = filmList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.film,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position)
    {
        viewHolder.tittle.setText(filmList.get(position).getTittle());
        viewHolder.episode_id.setText(String.valueOf(filmList.get(position)));
        viewHolder.opening.setText(filmList.get(position).getOpening_crawl());
        viewHolder.director.setText(filmList.get(position).getDirector());
        viewHolder.edited.setText(filmList.get(position).getEdited());
        viewHolder.producer.setText(filmList.get(position).getProducer());
        viewHolder.created.setText(filmList.get(position).getCreated());
        viewHolder.url.setText(filmList.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return  filmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tittle, episode_id, opening, director, producer, url, created, edited;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tittle = itemView.findViewById(R.id.tittle);
            episode_id = itemView.findViewById(R.id.episode);
            opening = itemView.findViewById(R.id.opennig);
            director = itemView.findViewById(R.id.director);
            producer = itemView.findViewById(R.id.producer);
            url = itemView.findViewById(R.id.url);
            created = itemView.findViewById(R.id.created);
            edited = itemView.findViewById(R.id.edited);

        }
    }
}

package xyz.zzp.ass_movie.activities.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.zzp.ass_movie.R;
import xyz.zzp.ass_movie.activities.activities.viewholders.ItemMovieTypesViewHolder;

/**
 * Created by Lenovo on 12/17/2017.
 */

public class MovieTypesAdaper extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View movieTypesview = layoutInflater.inflate(R.layout.item_movie_types,parent,false);
        ItemMovieTypesViewHolder itemMovieTypesViewHolder = new ItemMovieTypesViewHolder(movieTypesview);
        return itemMovieTypesViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }
}

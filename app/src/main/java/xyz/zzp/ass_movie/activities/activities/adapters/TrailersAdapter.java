package xyz.zzp.ass_movie.activities.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.zzp.ass_movie.R;
import xyz.zzp.ass_movie.activities.activities.viewholders.ItemTrailersViewHolder;

/**
 * Created by Lenovo on 12/13/2017.
 */

public class TrailersAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View trailerItemview = layoutInflater.inflate(R.layout.item_trailer,parent,false);
        ItemTrailersViewHolder itemTrailersViewHolder = new ItemTrailersViewHolder(trailerItemview);
        return itemTrailersViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

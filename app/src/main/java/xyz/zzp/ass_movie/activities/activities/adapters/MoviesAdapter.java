package xyz.zzp.ass_movie.activities.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.zzp.ass_movie.R;
import xyz.zzp.ass_movie.activities.activities.data.vo.PopularMoviesVO;
import xyz.zzp.ass_movie.activities.activities.delegates.MovieActionDelegates;
import xyz.zzp.ass_movie.activities.activities.viewholders.ItemMoviesViewHolder;

/**
 * Created by Lenovo on 12/6/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<ItemMoviesViewHolder> {

    private MovieActionDelegates mMovieActionDelegates;
    private List<PopularMoviesVO> mPopularmovies;

    public MoviesAdapter(MovieActionDelegates movieActionDelegates){
        mMovieActionDelegates = movieActionDelegates;
        mPopularmovies = new ArrayList<>();
    }
    @Override
    public ItemMoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View movieItemView = inflater.inflate(R.layout.item_movies, parent , false);
        ItemMoviesViewHolder itemMoviesViewHolder = new ItemMoviesViewHolder(movieItemView,mMovieActionDelegates);
        return itemMoviesViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemMoviesViewHolder holder, int position) {
        holder.setMovie(mPopularmovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mPopularmovies.size();
    }

    public void setMovies(List<PopularMoviesVO> popularMovies){
        mPopularmovies = popularMovies;
        notifyDataSetChanged();
    }

}

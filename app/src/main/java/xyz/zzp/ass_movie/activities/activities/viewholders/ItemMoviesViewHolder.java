package xyz.zzp.ass_movie.activities.activities.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.*;
import butterknife.ButterKnife;
import xyz.zzp.ass_movie.R;
import xyz.zzp.ass_movie.activities.activities.data.vo.PopularMoviesVO;
import xyz.zzp.ass_movie.activities.activities.delegates.MovieActionDelegates;

/**
 * Created by Lenovo on 12/6/2017.
 */

public class ItemMoviesViewHolder extends RecyclerView.ViewHolder {
    private MovieActionDelegates mMovieActionDelegates;

    @BindView(R.id.tv_movie_title)
    TextView movieTitle;

    @BindView(R.id.iv_movie_cover)
    ImageView movieCover;

    @BindView(R.id.tv_rating_text)
    TextView rating;

    public ItemMoviesViewHolder(final View itemView,MovieActionDelegates movieActionDelegates)
    {
        super(itemView);
        ButterKnife.bind(this,itemView);

        mMovieActionDelegates = movieActionDelegates;
    }
    @OnClick(R.id.rl_movie_card)
    public void onMovieItemTap(View view){
        mMovieActionDelegates.onTapMovieItem();
    }

    public void setMovie(PopularMoviesVO movies){
        movieTitle.setText(movies.getTitle());
        Glide.with(movieCover.getContext())
                .load(movies.getPosterPath())
                .into(movieCover);
    }
}



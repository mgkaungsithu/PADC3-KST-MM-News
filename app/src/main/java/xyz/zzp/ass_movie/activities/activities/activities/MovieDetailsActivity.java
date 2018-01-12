package xyz.zzp.ass_movie.activities.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import butterknife.*;
import butterknife.ButterKnife;
import xyz.zzp.ass_movie.*;
import xyz.zzp.ass_movie.R;
import xyz.zzp.ass_movie.activities.activities.adapters.MovieReviewsAdapter;
import xyz.zzp.ass_movie.activities.activities.adapters.MovieTypesAdaper;
import xyz.zzp.ass_movie.activities.activities.adapters.TrailersAdapter;

/**
 * Created by Lenovo on 12/12/2017.
 */

public class MovieDetailsActivity extends AppCompatActivity {
    @BindView(R.id.rv_movie_trailer)
    RecyclerView rvMovieTrailer;

    @BindView(R.id.rv_movie_types)
    RecyclerView rvMovieTypes;

    @BindView(R.id.rv_movie_reviews)
    RecyclerView rvMovieReviews;
    public static Intent newIntent(Context context)
    {
        Intent intent = new Intent(context,MovieDetailsActivity.class);
        return intent;
    }
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this,this);

        MovieTypesAdaper movieTypesAdaper = new MovieTypesAdaper();
        LinearLayoutManager linearLayoutManagerMovieTypes = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvMovieTypes.setLayoutManager(linearLayoutManagerMovieTypes);
        rvMovieTypes.setAdapter(movieTypesAdaper);

        TrailersAdapter trailersAdapter = new TrailersAdapter();
        LinearLayoutManager linearLayoutManagerTrailers = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvMovieTrailer.setLayoutManager(linearLayoutManagerTrailers);
        rvMovieTrailer.setAdapter(trailersAdapter);

        MovieReviewsAdapter movieReviewsAdapter = new MovieReviewsAdapter();
        LinearLayoutManager linearLayoutManagerReview = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvMovieReviews.setLayoutManager(linearLayoutManagerReview);
        rvMovieReviews.setAdapter(movieReviewsAdapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
}

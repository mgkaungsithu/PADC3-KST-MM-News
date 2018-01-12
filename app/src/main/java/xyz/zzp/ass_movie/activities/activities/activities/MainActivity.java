package xyz.zzp.ass_movie.activities.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.*;
import butterknife.ButterKnife;
import butterknife.*;
import xyz.zzp.ass_movie.*;
import xyz.zzp.ass_movie.R;
import xyz.zzp.ass_movie.activities.activities.MovieApp;
import xyz.zzp.ass_movie.activities.activities.adapters.MoviesAdapter;
import xyz.zzp.ass_movie.activities.activities.data.models.MoviesModel;
import xyz.zzp.ass_movie.activities.activities.delegates.MovieActionDelegates;
import xyz.zzp.ass_movie.activities.activities.events.LoadedMovieEvent;

public class MainActivity extends AppCompatActivity implements MovieActionDelegates{
    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private MoviesAdapter mMoviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this,this);
        setSupportActionBar(toolbar);

        mMoviesAdapter = new MoviesAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false);

        rvMovie.setLayoutManager(linearLayoutManager);
        rvMovie.setAdapter(mMoviesAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        MoviesModel.getObjectInstance().loadMovies();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapMovieItem() {
        Intent intent = new Intent(getApplicationContext(),MovieDetailsActivity.class);
        startActivity(intent);

    }

    @Override
    public void onTapMovieImage() {

    }

    @Override
    public void onTapMovieOverView() {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMovieLoaded(LoadedMovieEvent loadedMovieEvent){
        Log.d(MovieApp.LOG_TAG,"LoadedMovieEvent=" +loadedMovieEvent.getMoviesList().size());
        mMoviesAdapter.setMovies(loadedMovieEvent.getMoviesList());
    }
}

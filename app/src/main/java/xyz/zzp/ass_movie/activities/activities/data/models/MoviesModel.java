package xyz.zzp.ass_movie.activities.activities.data.models;

import java.net.HttpURLConnection;

import xyz.zzp.ass_movie.activities.activities.network.HttpUrlConnectionDataAgent;
import xyz.zzp.ass_movie.activities.activities.network.MovieDataAgent;

/**
 * Created by Lenovo on 1/1/2018.
 */

public class MoviesModel {

    private static MoviesModel sObjectInstance;
    private MovieDataAgent mMovieDataAgent;
    private MoviesModel(){
        mMovieDataAgent = HttpUrlConnectionDataAgent.getObjectInstance();
    }

    public static MoviesModel getObjectInstance() {
        if(sObjectInstance == null){
            sObjectInstance = new MoviesModel();
        }
        return sObjectInstance;
    }
    public void loadMovies(){
        mMovieDataAgent.loadMovies();
    }
}

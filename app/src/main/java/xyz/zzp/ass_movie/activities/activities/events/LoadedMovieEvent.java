package xyz.zzp.ass_movie.activities.activities.events;

import java.util.List;

import xyz.zzp.ass_movie.activities.activities.data.vo.PopularMoviesVO;

/**
 * Created by Lenovo on 1/2/2018.
 */

public class LoadedMovieEvent {

    private List<PopularMoviesVO> moviesList;

    public LoadedMovieEvent(List<PopularMoviesVO> moviesList){
        this.moviesList = moviesList;
    }

    public List<PopularMoviesVO> getMoviesList() {
        return moviesList;
    }
}

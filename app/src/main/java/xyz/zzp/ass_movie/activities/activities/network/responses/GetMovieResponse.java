package xyz.zzp.ass_movie.activities.activities.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.zzp.ass_movie.activities.activities.data.vo.PopularMoviesVO;

/**
 * Created by Lenovo on 1/1/2018.
 */

public class GetMovieResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;

    @SerializedName("popular-movies")
    private List<PopularMoviesVO> popularMovies;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<PopularMoviesVO> getPopularMovies() {
        return popularMovies;
    }
}
